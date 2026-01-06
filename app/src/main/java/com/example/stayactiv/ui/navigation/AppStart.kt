package com.example.stayactiv.ui.navigation

import WeatherViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.stayactiv.data.repository.WeatherRepository
import com.example.stayactiv.ui.screens.ActivityDetailScreen
import com.example.stayactiv.ui.screens.ActivityScreen
import com.example.stayactiv.ui.screens.AddActivityScreen
import com.example.stayactiv.ui.screens.WeatherScreen

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AppStart() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ActivitiesRoute,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<ActivitiesRoute> {
                ActivityScreen(
                    onActivityClick = { id ->
                        navController.navigate(
                            ActivityDetailRoute(id)
                        )
                    },
                    onAddActivity = {
                        navController.navigate(AddActivityRoute)
                    }
                )
            }

            composable<WeatherRoute> {
                WeatherScreen(
                    viewModel = WeatherViewModel(WeatherRepository()),
                    onClick =
                )
            }

            composable<ActivityDetailRoute> { backStackEntry ->
                val route = backStackEntry.toRoute<ActivityDetailRoute>()

                ActivityDetailScreen(
                    activityId = route.activityId,
                    onBack = { navController.popBackStack() }
                )
            }

            composable<AddActivityRoute> {
                AddActivityScreen(
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}
