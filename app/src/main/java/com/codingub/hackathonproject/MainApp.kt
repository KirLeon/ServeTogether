package com.codingub.hackathonproject

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 *
 */
@HiltAndroidApp
class MainApp : Application() {

    init{
        Instance = this
    }

    companion object {
        private var Instance: MainApp? = null
        fun getInstance(): MainApp = Instance!!
    }
}