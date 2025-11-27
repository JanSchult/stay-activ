package com.example.stayactiv.data.model

data class DailyWeatherApi(
    val time: List<String>,
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
    val uv_index_max: List<Double>,
    val precipitation_probability_max: List<Int>,
    val weather_code: List<Int>,
    val sunrise: List<String>,
    val sunset: List<String>
)