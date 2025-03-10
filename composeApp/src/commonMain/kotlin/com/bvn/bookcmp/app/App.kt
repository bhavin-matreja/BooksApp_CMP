/*
    app package - logic to wire all things together
    navigation, initial setup

    app package is allowed to access any other feature and package in our project
    without any architecture constraints
 */

package com.bvn.bookcmp.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.bvn.bookcmp.book.domain.Book
import com.bvn.bookcmp.book.presentation.SelectedBookViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import com.bvn.bookcmp.book.presentation.book_list.BookListScreenRoot
import com.bvn.bookcmp.book.presentation.book_list.BookListViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Route.BookGraph
        ) {
            navigation<Route.BookGraph>(
                startDestination = Route.BookList
            ) {
                composable<Route.BookList> {
                    val viewModel = koinViewModel<BookListViewModel>()
                    val selectedBookViewModel =
                        it.sharedKoinViewModel<SelectedBookViewModel>(navController)

                    // if we navigate back to list, we want to remove selected book
                    LaunchedEffect(true) {
                        selectedBookViewModel.onSelectedBook(null)
                    }
                    BookListScreenRoot(
                        viewModel = viewModel,
                        onBookClick = { book ->
                            selectedBookViewModel.onSelectedBook(book)
                            navController.navigate(
                                Route.BookDetail(book.id)
                            )
                        }
                    )
                }

                composable<Route.BookDetail> { backStackEntry ->
                    val args = backStackEntry.toRoute<Route.BookDetail>()
                    val selectedBookViewModel =
                        backStackEntry.sharedKoinViewModel<SelectedBookViewModel>(navController)
                    val selectedBook by selectedBookViewModel.selectedBook.collectAsStateWithLifecycle()
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Book Detail screen, the id is $selectedBook")
                        // get the id from arguements
                        // Text("Book Detail screen, the id is ${args.id}")
                    }
                }
            }
        }
    }
}

/*
    Create a shared view model that attaches to the parent graph rather than
    to a single screen
 */
@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    // current destination parent = BookGraph
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentBackStackEntry = remember(this) {
         navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        // scope viewmodel to parent navgraph rather than to current navbackstackentry i.e. current screen
        // that will scope to just single screen
        viewModelStoreOwner = parentBackStackEntry
    )
}