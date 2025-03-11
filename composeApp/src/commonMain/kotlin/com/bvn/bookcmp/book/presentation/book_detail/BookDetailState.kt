package com.bvn.bookcmp.book.presentation.book_detail

import com.bvn.bookcmp.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true, // need to fetch description for new api
    val isFavorite: Boolean = false,
    val book: Book? = null
)