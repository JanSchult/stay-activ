package com.example.stayactiv.data.remote

import com.example.stayactiv.data.model.WeatherResponseApi
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoApi {

    @GET("v1/forecast")
    suspend fun getWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,

        // --- Aktuelle Daten ---
        @Query("current") current: String =
            "temperature_2m,apparent_temperature,weather_code,wind_speed_10m,wind_direction_10m,relative_humidity_2m,uv_index",

        // --- Tagesdaten ---
        @Query("daily") daily: String =
            "temperature_2m_max,temperature_2m_min,uv_index_max,precipitation_probability_max,weather_code,sunrise,sunset",

        // --- Zeitzone setzen ---
        @Query("timezone") timezone: String = "auto"
    ): WeatherResponseApi
}
