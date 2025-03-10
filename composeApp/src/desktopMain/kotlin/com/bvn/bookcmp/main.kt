package com.bvn.bookcmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.bvn.bookcmp.di.initKoin
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.context.startKoin

fun main() {
    initKoin()
    application { // application is composable
        Window(
            onCloseRequest = ::exitApplication,
            title = "BookApp_CMP",
        ) {
            App()
        }
    }
}