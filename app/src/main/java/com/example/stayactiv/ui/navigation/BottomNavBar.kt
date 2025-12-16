package com.example.stayactiv.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute


@Composable
fun BottomBar(navController: NavHostController) {

    val currentRoute =
        navController.currentBackStackEntryAsState().value?.toRoute<Any>()

    NavigationBar {

        NavigationBarItem(
            selected = currentRoute is WeatherRoute,
            onClick = {
                navController.navigate(WeatherRoute) {
                    popUpTo(WeatherRoute)
                    launchSingleTop = true
                }
            },
            icon = { Icon(Icons., null) },
            label = { Text("Wetter") }
        )

        NavigationBarItem(
            selected = currentRoute is ActivitiesRoute,
            onClick = {
                navController.navigate(ActivitiesRoute) {
                    popUpTo(WeatherRoute)
                    launchSingleTop = true
                }
            },
            icon = { Icon(Icons.Filled.AccountCircle, null) },
            label = { Text("Aktivitäten") }
        )
    }
}
