package com.bvn.bookcmp.book.presentation.book_list

import com.bvn.bookcmp.book.domain.Book
import com.bvn.bookcmp.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "kotlin",
    val searchResults: List<Book> = emptyList(),
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = true,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)
