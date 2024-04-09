package com.rjornelas.marvelapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarvelApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}