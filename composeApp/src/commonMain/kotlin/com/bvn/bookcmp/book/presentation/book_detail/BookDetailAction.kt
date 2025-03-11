package com.bvn.bookcmp.book.presentation.book_detail

import com.bvn.bookcmp.book.domain.Book

sealed interface BookDetailAction {
    data object onBackClick: BookDetailAction
    data object onFavoriteClick: BookDetailAction
    data class onSelectedBookChange(val book: Book): BookDetailAction
}