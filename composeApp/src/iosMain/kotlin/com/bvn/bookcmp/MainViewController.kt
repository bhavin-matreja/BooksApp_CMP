package com.bvn.bookcmp

import androidx.compose.ui.window.ComposeUIViewController
import com.bvn.bookcmp.app.App
import com.bvn.bookcmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}