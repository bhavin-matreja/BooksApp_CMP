package com.bvn.bookcmp.book.presentation.book_list

import com.bvn.bookcmp.book.domain.Book

sealed interface BookListAction {
    data class OnSearchQueryChanged(val query: String): BookListAction
    data class OnBookClick(val book: Book): BookListAction
    data class OnTabSelected(val index: Int): BookListAction
}