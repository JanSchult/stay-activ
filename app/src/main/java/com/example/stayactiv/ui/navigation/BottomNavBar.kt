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

    NavigationBar {

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(WeatherRoute) {
                    launchSingleTop = true
                }
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.outline_cloud_24),
                    contentDescription = "Wetter"
                )
            },
            label = { Text("Wetter") }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(ActivitiesRoute) {
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
