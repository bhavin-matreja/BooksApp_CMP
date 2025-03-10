package com.bvn.bookcmp

import android.app.Application
import com.bvn.bookcmp.di.initKoin
import org.koin.android.ext.koin.androidContext

class BookApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            // modules() add modules that are just required for android, if any
            androidContext(this@BookApp)
        }
    }
}