package com.bvn.bookcmp.book.data.repository

import com.bvn.bookcmp.book.data.mappers.toBook
import com.bvn.bookcmp.book.data.network.RemoteBookDataSource
import com.bvn.bookcmp.book.domain.Book
import com.bvn.bookcmp.book.domain.BookRepository
import com.bvn.bookcmp.core.domain.DataError
import com.bvn.bookcmp.core.domain.Result
import com.bvn.bookcmp.core.domain.map

class DefaultBookRepository(
    private val remoteBookDataSource: RemoteBookDataSource
): BookRepository {
    override suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote> {
        return remoteBookDataSource
            .searchBooks(query)
            .map { searchResponseDto ->
                searchResponseDto.results.map { it.toBook()}
            }
    }
}