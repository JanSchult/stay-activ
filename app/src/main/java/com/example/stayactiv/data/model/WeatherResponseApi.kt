package com.example.stayactiv.data.model

data class WeatherResponseApi(
    val current: CurrentWeatherApi,
    val daily: DailyWeatherApi
)
