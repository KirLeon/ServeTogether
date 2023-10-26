package com.codingub.hackathonproject.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.codingub.hackathonproject.ui.screens.KeyRegistrationScreen
import com.codingub.hackathonproject.ui.theme.HackathonProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var Instance: MainActivity? = null
        fun getInstance(): MainActivity = Instance!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Instance = this
        setContent {
            HackathonProjectTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    KeyRegistrationScreen()
                }
            }
        }
    }
}

