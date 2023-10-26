package com.codingub.hackathonproject.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.codingub.hackathonproject.ui.navigation.BottomNavigationBar
import com.codingub.hackathonproject.ui.screens.announcements.AnnouncementScreen
import com.codingub.hackathonproject.ui.screens.groups.GroupsScreen
import com.codingub.hackathonproject.ui.screens.registration.RegistrationScreen
import com.codingub.hackathonproject.ui.screens.shop.ShopScreen
import com.codingub.hackathonproject.ui.screens.shop.shopItem
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
            val navController = rememberNavController()
            HackathonProjectTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                   GroupsScreen(navController = navController)
                }
            }
        }
    }
}

