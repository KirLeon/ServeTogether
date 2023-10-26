package com.codingub.hackathonproject.ui

import RegistrationScreen
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codingub.hackathonproject.sdk.FragmentRoute
import com.codingub.hackathonproject.ui.screens.AuthorizationScreen
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
                    val navController = rememberNavController()


                    NavHost(
                        navController = navController,
                        startDestination = FragmentRoute.Login
                    ) {
                        composable(route = FragmentRoute.Login) { AuthorizationScreen(navController)}
                        composable(route = FragmentRoute.Register) { RegistrationScreen(navController)}
                        composable(route = FragmentRoute.InviteKey) { KeyRegistrationScreen(navController) }
                        composable(route = FragmentRoute.Announcement) { AuthorizationScreen(navController)}
                    }
                }
            }
        }
    }
}

