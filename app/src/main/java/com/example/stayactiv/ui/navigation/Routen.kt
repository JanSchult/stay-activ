package com.example.stayactiv.ui.navigation
import kotlinx.serialization.Serializable


@Serializable
object WeatherRoute

@Serializable
object ActivitiesRoute

@Serializable
data class ActivityDetailRoute(val activityId: String)

@Serializable
object AddActivityRoute
