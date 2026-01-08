package com.example.stayactiv.ui.navigation

import WeatherViewModel
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.stayactiv.data.repository.WeatherRepository
import com.example.stayactiv.ui.screens.ActivityDetailScreen
import com.example.stayactiv.ui.screens.ActivityScreen
import com.example.stayactiv.ui.screens.AddActivityScreen
import com.example.stayactiv.ui.screens.WeatherScreen
import com.example.stayactiv.viewmodel.ActivitiesViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun AppStart() {
    val navController = rememberNavController()
    val activitiesViewModel: ActivitiesViewModel = koinViewModel()
    val weatherViewModel: WeatherViewModel = koinViewModel()

    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ActivitiesRoute,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable<ActivitiesRoute> {

                val currentWeather by weatherViewModel.currentWeather.collectAsState()

                ActivityScreen(
                    viewModel = activitiesViewModel,
                    currentWeather = currentWeather,
                    onAdd = {
                        navController.navigate(AddActivityRoute)
                    },
                    onClick = { activity ->
                        navController.navigate(
                            ActivityDetailRoute(activity.id)
                        )
                    }
                )
            }

            composable<WeatherRoute> {
                WeatherScreen(
                    state = weatherViewModel.uiState.collectAsState().value,
                    onRetry = {
                        weatherViewModel.loadWeather(lat = 52.520008, lon = 13.404954)
                    }
                )
            }

            composable<ActivityDetailRoute> { backStackEntry ->
                val route = backStackEntry.toRoute<ActivityDetailRoute>()
                val activity =
                    activitiesViewModel.getActivityById(route.activityId)

                activity?.let {
                    ActivityDetailScreen(activity = it)
                }
            }

            composable<AddActivityRoute> {
                AddActivityScreen(
                    state = activitiesViewModel.addUiState.collectAsState().value,
                    onTitleChange = activitiesViewModel::onTitleChange,
                    onCategoryChange = activitiesViewModel::onCategoryChange,
                    onDurationChange = activitiesViewModel::onDurationChange,
                    onRatingChange = activitiesViewModel::onRatingChange,
                    onNoteChange = activitiesViewModel::onNoteChange,
                    onSave = {
                        activitiesViewModel.saveActivity()
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}