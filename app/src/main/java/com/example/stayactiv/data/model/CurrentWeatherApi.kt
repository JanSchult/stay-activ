package com.example.stayactiv.data.model

data class CurrentWeatherApi(
    val temperature_2m: Double?,
    val apparent_temperature: Double?,
    val weather_code: Int?,
    val wind_speed_10m: Double?,
    val wind_direction_10m: Int?,
    val relative_humidity_2m: Int?,
    val uv_index: Double?
)