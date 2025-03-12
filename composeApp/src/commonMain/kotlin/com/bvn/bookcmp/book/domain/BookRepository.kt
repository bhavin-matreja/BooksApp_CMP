package com.bvn.bookcmp.book.domain

import com.bvn.bookcmp.core.domain.DataError
import com.bvn.bookcmp.core.domain.Result

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>
}