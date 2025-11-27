package com.example.stayactiv.data.model

import com.example.stayactiv.util.WeatherCondition

data class WeatherToday(
    val temperature: Double,
    val feelsLike: Double,
    val weather: WeatherCondition,
    val description: String,
    val humidity: Int,
    val windSpeed: Double,
    val windDirection: Int,
    val uvIndex: Double
)
