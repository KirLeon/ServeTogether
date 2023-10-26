package com.codingub.hackathonproject.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.codingub.hackathonproject.ui.screens.AuthorizationScreen
import com.codingub.hackathonproject.ui.screens.KeyRegistrationScreen
import com.codingub.hackathonproject.ui.screens.announcements.AnnouncementScreen
import com.codingub.hackathonproject.ui.screens.groups.GroupsScreen
import com.codingub.hackathonproject.ui.screens.registration.RegistrationScreen

@Composable
fun BottomNavigationBar(/*navController: NavController*/) {
    val items = listOf(
        NavigationItem.Shop,
        NavigationItem.Home,
        NavigationItem.Groups,
        NavigationItem.Settings,
    )
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Scaffold(

        bottomBar = {
            androidx.compose.material.BottomNavigation(backgroundColor = Color.White) {

                items.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            item.icon.let {
                                Icon(
                                    imageVector = it,
                                    contentDescription = null
                                )
                            }
                        },
                        selected = currentDestination?.hierarchy?.any {
                            it.route == item.route
                        } == true,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { padding ->


        NavHost(
            navController = navController,
            startDestination = NavigationItem.Home.route,
            modifier = Modifier.then(Modifier.padding(padding))
        ) {
            composable(NavigationItem.Home.route) {
                AuthorizationScreen()
            }
            composable(NavigationItem.Shop.route) {

            }
            composable(NavigationItem.Groups.route) {
                GroupsScreen(navController = navController)
            }
            composable(NavigationItem.Settings.route) {
                KeyRegistrationScreen()
            }

        }
    }

}


