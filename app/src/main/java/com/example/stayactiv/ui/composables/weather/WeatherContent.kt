package com.example.stayactiv.ui.composables.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.stayactiv.data.model.WeatherToday
import com.example.stayactiv.data.model.WeatherTomorrow

@Composable
fun WeatherContent(
    today: WeatherToday,
    tomorrow: WeatherTomorrow
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        WeatherHeader(
            temperature = today.temperature,
            description = today.description,
            iconRes = today.
        )

        Column(Modifier.padding(horizontal = 16.dp)) {
            WeatherDetailRow(
                icon = Icons.,
                label = "Gefühlt",
                value = "${today.feelsLike}°"
            )
            WeatherDetailRow(
                icon = Icons.,
                label = "Wind",
                value = "${today.windSpeed} km/h"
            )
            WeatherDetailRow(
                icon = Icons.,
                label = "Luftfeuchtigkeit",
                value = "${today.humidity}%"
            )
            WeatherDetailRow(
                icon = Icons.,
                label = "UV Index",
                value = today.uvIndex.toString()
            )
        }

        TomorrowWeatherCard(tomorrow)

        SunriseSunsetCard(
            sunrise = tomorrow.sunrise,
            sunset = tomorrow.sunset
        )
    }
}