package com.example.stayactiv.data.model


object WeatherMapper {

    fun mapToDomain(api: WeatherResponseApi): WeatherData {
        val today = mapToday(api.current, api.daily)
        val tomorrow = mapTomorrow(api.daily)

        return WeatherData(
            today = today,
            tomorrow = tomorrow
        )
    }

    // -----------------------------------
    // TODAY
    // -----------------------------------
    private fun mapToday(
        current: CurrentWeatherApi,
        daily: DailyWeatherApi
    ): WeatherToday {

        val weatherCondition =
            WeatherCodeMapper.toCondition(current.weather_code ?: 0)

        return WeatherToday(
            temperature = current.temperature_2m ?: 0.0,
            feelsLike = current.apparent_temperature ?: 0.0,
            weather = weatherCondition,
            description = WeatherCodeMapper.toDescription(current.weather_code ?: 0),
            humidity = current.relative_humidity_2m ?: 0,
            windSpeed = current.wind_speed_10m ?: 0.0,
            windDirection = current.wind_direction_10m ?: 0,
            uvIndex = current.uv_index ?: 0.0
        )
    }

    // -----------------------------------
    // TOMORROW
    // -----------------------------------
    private fun mapTomorrow(
        daily: DailyWeatherApi
    ): WeatherTomorrow {

        val indexTomorrow = 1 // index 0 = heute, 1 = morgen

        val weatherCode = daily.weather_code.getOrNull(indexTomorrow) ?: 0
        val condition = WeatherCodeMapper.toCondition(weatherCode)

        return WeatherTomorrow(
            maxTemp = daily.temperature_2m_max.getOrNull(indexTomorrow) ?: 0.0,
            minTemp = daily.temperature_2m_min.getOrNull(indexTomorrow) ?: 0.0,
            weather = condition,
            rainProbability = daily.precipitation_probability_max.getOrNull(indexTomorrow) ?: 0,
            uvIndex = daily.uv_index_max.getOrNull(indexTomorrow) ?: 0.0,
            sunrise = daily.sunrise.getOrNull(indexTomorrow) ?: "",
            sunset = daily.sunset.getOrNull(indexTomorrow) ?: "",
            description = WeatherCodeMapper.toDescription(weatherCode)
        )
    }
}
