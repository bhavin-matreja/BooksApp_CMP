package com.bvn.bookcmp

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.bvn.bookcmp.di.initKoin
import io.ktor.client.engine.darwin.Darwin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}