package com.example.stayactiv.util

sealed class WeatherEvent {
    data class ShowError(val message: String): WeatherEvent()
    object None: WeatherEvent()
}
