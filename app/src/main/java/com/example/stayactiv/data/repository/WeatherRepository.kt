package com.example.stayactiv.data.repository

import com.example.stayactiv.data.model.WeatherToday
import com.example.stayactiv.data.model.WeatherTomorrow
import com.example.stayactiv.data.remote.OpenMeteoApiService
import com.example.stayactiv.util.WeatherCondition
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class WeatherRepository(
    private val api: OpenMeteoApiService
) {

    suspend fun getWeather(latitude: Double, longitude: Double): Flow<Pair<WeatherToday, WeatherTomorrow>> = flow {
        val response = api.getWeatherForecast(latitude, longitude)

        // Heutiges Datum
        val todayIndex = 0
        val tomorrowIndex = 1

        // Mapper für heute
        val current = response.current
        val weatherToday = WeatherToday(
            temperature = current.temperature_2m ?: 0.0,
            feelsLike = current.apparent_temperature ?: 0.0,
            weather = mapWeatherCode(current.weather_code),
            description = current.weather_code?.let { mapWeatherDescription(it) } ?: "Unknown",
            humidity = current.relative_humidity_2m ?: 0,
            windSpeed = current.wind_speed_10m ?: 0.0,
            windDirection = current.wind_direction_10m ?: 0,
            uvIndex = current.uv_index ?: 0.0
        )

        // Mapper für morgen
        val daily = response.daily
        val weatherTomorrow = WeatherTomorrow(
            maxTemp = daily.temperature_2m_max.getOrNull(tomorrowIndex) ?: 0.0,
            minTemp = daily.temperature_2m_min.getOrNull(tomorrowIndex) ?: 0.0,
            weather = daily.weather_code.getOrNull(tomorrowIndex)?.let { mapWeatherCode(it) } ?: WeatherCondition.UNKNOWN,
            rainProbability = daily.precipitation_probability_max.getOrNull(tomorrowIndex) ?: 0,
            uvIndex = daily.uv_index_max.getOrNull(tomorrowIndex) ?: 0.0,
            sunrise = daily.sunrise.getOrNull(tomorrowIndex) ?: "",
            sunset = daily.sunset.getOrNull(tomorrowIndex) ?: "",
            description = daily.weather_code.getOrNull(tomorrowIndex)?.let { mapWeatherDescription(it) } ?: "Unknown"
        )

        emit(Pair(weatherToday, weatherTomorrow))
    }

    // Mapper von Open-Meteo weather_code → Domain Enum
    private fun mapWeatherCode(code: Int?): WeatherCondition {
        return when (code) {
            0 -> WeatherCondition.SUNNY
            1, 2 -> WeatherCondition.PARTLY_CLOUDY
            3 -> WeatherCondition.CLOUDY
            45, 48 -> WeatherCondition.FOGGY
            51, 53, 55, 61, 63, 65, 80, 81, 82 -> WeatherCondition.RAINY
            71, 73, 75, 77, 85, 86 -> WeatherCondition.SNOWY
            95, 96, 99 -> WeatherCondition.STORM
            else -> WeatherCondition.UNKNOWN
        }
    }

    // Optional: einfache Beschreibung
    private fun mapWeatherDescription(code: Int): String {
        return when (code) {
            0 -> "Clear sky"
            1, 2 -> "Partly cloudy"
            3 -> "Overcast clouds"
            45, 48 -> "Fog"
            51, 53, 55 -> "Drizzle"
            61, 63, 65 -> "Rain"
            71, 73, 75, 77 -> "Snow"
            80, 81, 82 -> "Rain showers"
            95, 96, 99 -> "Thunderstorm"
            85, 86 -> "Snow showers"
            else -> "Unknown"
        }
    }
}
