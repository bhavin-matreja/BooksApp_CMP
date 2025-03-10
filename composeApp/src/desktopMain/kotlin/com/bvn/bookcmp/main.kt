package com.bvn.bookcmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.bvn.bookcmp.app.App
import com.bvn.bookcmp.di.initKoin

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