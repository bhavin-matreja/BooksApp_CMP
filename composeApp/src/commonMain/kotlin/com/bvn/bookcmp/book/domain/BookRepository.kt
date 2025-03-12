package com.bvn.bookcmp.book.domain

import com.bvn.bookcmp.core.domain.DataError
import com.bvn.bookcmp.core.domain.EmptyResult
import com.bvn.bookcmp.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>

    fun getFavoriteBooks(): Flow<List<Book>> // don't want to use Book entity as it violates clean architecture
    fun isBookFavorite(bookId: String): Flow<Boolean>
    suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local>
    suspend fun deleteFromFavorite(bookId: String)
}