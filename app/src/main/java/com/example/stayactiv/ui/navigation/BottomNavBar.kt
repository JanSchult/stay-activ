package com.example.stayactiv.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.toRoute
import com.example.stayactiv.R


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
            {
                Icon(
                    painter = painterResource(id = R.drawable.outline_cloud_24),
                    contentDescription = null
                )
            },
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
            icon = {
                Icon(
                    painter = painterResource(R.drawable.outline_self_improvement),
                    contentDescription = "Aktivitäten"
                )
            },
            label = { Text("Aktivitäten") }
        )
    }
}
