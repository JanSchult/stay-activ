package com.example.stayactiv.data.model

data class OpenMeteoResponse(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val current: CurrentWeatherApi,
    val daily: DailyWeatherApi
)
