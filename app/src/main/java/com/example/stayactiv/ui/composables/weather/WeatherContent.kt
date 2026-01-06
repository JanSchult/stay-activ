package com.example.stayactiv.ui.composables.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.stayactiv.R
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
            iconRes = if (today.isDay) R.drawable.outline_wb_sunny_24 else R.drawable.outline_nightlight_24
        )

        Column(Modifier.padding(horizontal = 16.dp)) {
            WeatherDetailRow(
                painter = painterResource(id = R.drawable.outline_device_thermostat_24),
                label = "Gefühlt",
                value = "${today.feelsLike}°"
            )
            WeatherDetailRow(
                painter = painterResource(id = R.drawable.outline_air_24),
                label = "Wind",
                value = "${today.windSpeed} km/h"
            )
            WeatherDetailRow(
                painter = painterResource(id =R.drawable.outline_water_drop_24),
                label = "Luftfeuchtigkeit",
                value = "${today.humidity}%"
            )
            WeatherDetailRow(
                painter = painterResource(id =R.drawable.outline_wb_sunny_24),
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