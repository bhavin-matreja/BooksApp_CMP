package com.bvn.bookcmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "BookApp_CMP",
    ) {
        App()
    }
}