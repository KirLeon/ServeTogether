package com.codingub.hackathonproject.ui.navigation

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(val route: String, var icon: ImageVector) {
    object Shop: NavigationItem("shop", Icons.Default.ShoppingCart)
    object Home: NavigationItem("home", Icons.Default.Home)
    object Settings: NavigationItem("settings", Icons.Default.Settings)
    object Groups: NavigationItem("groups", Icons.Default.Add)

}
