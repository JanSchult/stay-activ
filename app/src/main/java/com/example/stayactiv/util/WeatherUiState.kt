package com.example.stayactiv.util

import com.example.stayactiv.data.model.WeatherToday
import com.example.stayactiv.data.model.WeatherTomorrow

data class WeatherUiState(
    val today: WeatherToday? = null,
    val tomorrow: WeatherTomorrow? = null,
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)