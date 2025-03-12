package com.bvn.bookcmp.book.data.repository

import androidx.sqlite.SQLiteException
import com.bvn.bookcmp.book.data.database.FavoriteBookDao
import com.bvn.bookcmp.book.data.mappers.toBook
import com.bvn.bookcmp.book.data.mappers.toBookEntity
import com.bvn.bookcmp.book.data.network.RemoteBookDataSource
import com.bvn.bookcmp.book.domain.Book
import com.bvn.bookcmp.book.domain.BookRepository
import com.bvn.bookcmp.core.domain.DataError
import com.bvn.bookcmp.core.domain.EmptyResult
import com.bvn.bookcmp.core.domain.Result
import com.bvn.bookcmp.core.domain.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource,
    private val favoriteBookDao: FavoriteBookDao
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { searchResponseDto ->
                searchResponseDto.results.map { it.toBook()}
            }
    }

    override suspend fun getBookDescription(bookId: String): Result<String?, DataError> {
        val localResult = favoriteBookDao.getFavoriteBook(bookId)
        return if (localResult == null) {
            remoteBookDataSource
                .getBookDetail(bookId)
                .map {
                    it.description
                }
        } else {
            Result.Success(localResult.description)
        }
    }

    override fun getFavoriteBooks(): Flow<List<Book>> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntities ->
                bookEntities.map { it.toBook() }
            }
    }

    override fun isBookFavorite(bookId: String): Flow<Boolean> {
        return favoriteBookDao
            .getFavoriteBooks()
            .map { bookEntitites ->
                bookEntitites.any { it.id == bookId }
            }
    }

    override suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local> {
        return try {
            favoriteBookDao.upsert(book.toBookEntity())
            Result.Success(Unit)
        } catch (e: SQLiteException) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun deleteFromFavorite(bookId: String) {
        favoriteBookDao.deleteFavoriteBook(bookId)
    }
}