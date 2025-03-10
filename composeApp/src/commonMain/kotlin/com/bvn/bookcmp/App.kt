package com.bvn.bookcmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.bvn.bookcmp.book.data.network.KtorRemoteBookDataSource
import com.bvn.bookcmp.book.data.repository.DefaultBookRepository
import com.bvn.bookcmp.book.presentation.book_list.BookListScreenRoot
import com.bvn.bookcmp.book.presentation.book_list.BookListViewModel
import com.bvn.bookcmp.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    MaterialTheme {
        BookListScreenRoot(
            viewModel = remember { BookListViewModel(
                bookRepository = DefaultBookRepository(
                    remoteBookDataSource = KtorRemoteBookDataSource(
                        httpClient = HttpClientFactory.create(engine)
                    )
                )
            ) },
            onBookClick = {}
        )
    }
}