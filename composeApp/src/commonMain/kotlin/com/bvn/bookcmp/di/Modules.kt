package com.bvn.bookcmp.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.bvn.bookcmp.book.data.database.DatabaseFactory
import com.bvn.bookcmp.book.data.database.FavoriteBookDatabase
import com.bvn.bookcmp.book.data.network.KtorRemoteBookDataSource
import com.bvn.bookcmp.book.data.network.RemoteBookDataSource
import com.bvn.bookcmp.book.data.repository.DefaultBookRepository
import com.bvn.bookcmp.book.domain.BookRepository
import com.bvn.bookcmp.book.presentation.SelectedBookViewModel
import com.bvn.bookcmp.book.presentation.book_detail.BookDetailViewModel
import com.bvn.bookcmp.book.presentation.book_list.BookListViewModel
import com.bvn.bookcmp.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule : Module

val sharedModule = module {

    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    viewModelOf(::BookListViewModel)
    viewModelOf(::SelectedBookViewModel)
    viewModelOf(::BookDetailViewModel)

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    single {
        get<FavoriteBookDatabase>().favoriteBookDao
    }
}