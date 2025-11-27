package com.example.stayactiv.data.remote

import com.example.stayactiv.data.model.OpenMeteoResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenMeteoApiService {

    @GET("v1/forecast")
    suspend fun getWeatherForecast(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current_weather") currentWeather: Boolean = true,
        @Query("hourly") hourly: String? = null,
        @Query("daily") daily: String = "temperature_2m_max,temperature_2m_min,uv_index_max,precipitation_probability_max,weather_code,sunrise,sunset",
        @Query("timezone") timezone: String = "auto"
    ): OpenMeteoResponse
}
