package com.bvn.bookcmp.book.data.network

import com.bvn.bookcmp.book.data.dto.BookWorkDto
import com.bvn.bookcmp.book.data.dto.SearchResponseDto
import com.bvn.bookcmp.core.domain.DataError
import com.bvn.bookcmp.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetail(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}