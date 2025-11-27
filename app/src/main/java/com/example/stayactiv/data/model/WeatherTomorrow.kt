package com.example.stayactiv.data.model

import com.example.stayactiv.util.WeatherCondition

data class WeatherTomorrow(
    val maxTemp: Double,
    val minTemp: Double,
    val weather: WeatherCondition,
    val rainProbability: Int,
    val uvIndex: Double,
    val sunrise: String,
    val sunset: String,
    val description: String
)
