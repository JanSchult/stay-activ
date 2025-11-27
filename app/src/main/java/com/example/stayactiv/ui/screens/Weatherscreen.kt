package com.example.stayactiv.ui.screens

import android.view.Surface
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stayactiv.data.model.WeatherToday
import com.example.stayactiv.data.model.WeatherTomorrow
import com.example.stayactiv.util.WeatherCondition
import com.example.stayactiv.util.WeatherUiState
import com.example.stayactiv.viewmodel.WeatherViewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    if (uiState.isLoading) {
        CircularProgressIndicator()
    } else if (uiState.errorMessage != null) {
        Text("Error: ${uiState.errorMessage}")
    } else {
        Column {
            uiState.today?.let {
                Text("Heute: ${it.temperature}°C, ${it.description}")
            }
            uiState.tomorrow?.let {
                Text("Morgen: ${it.maxTemp}°C/${it.minTemp}°C, ${it.description}")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WeatherScreenPreview() {
    val dummyToday = WeatherToday(
        temperature = 22.0,
        feelsLike = 21.5,
        weather = WeatherCondition.SUNNY,
        description = "Clear sky",
        humidity = 50,
        windSpeed = 10.0,
        windDirection = 90,
        uvIndex = 5.0
    )

    val dummyTomorrow = WeatherTomorrow(
        maxTemp = 24.0,
        minTemp = 16.0,
        weather = WeatherCondition.PARTLY_CLOUDY,
        rainProbability = 20,
        uvIndex = 6.0,
        sunrise = "06:30",
        sunset = "18:45",
        description = "Partly cloudy"
    )

    val dummyUiState = WeatherUiState(
        today = dummyToday,
        tomorrow = dummyTomorrow,
        isLoading = false,
        errorMessage = null
    )

    WeatherScreenPreviewContent(uiState = dummyUiState)
}

@Composable
fun WeatherScreenPreviewContent(uiState: WeatherUiState) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            uiState.today?.let {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Heute", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(4.dp))
                        Text("${it.temperature}°C, ${it.description}")
                        Text("Feels like: ${it.feelsLike}°C")
                        Text("Wind: ${it.windSpeed} km/h, Direction: ${it.windDirection}°")
                        Text("Humidity: ${it.humidity}%")
                        Text("UV Index: ${it.uvIndex}")
                    }
                }
            }

            uiState.tomorrow?.let {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Morgen", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(4.dp))
                        Text("${it.maxTemp}°C / ${it.minTemp}°C, ${it.description}")
                        Text("Rain probability: ${it.rainProbability}%")
                        Text("UV Index: ${it.uvIndex}")
                        Text("Sunrise: ${it.sunrise}, Sunset: ${it.sunset}")
                    }
                }
            }
        }
    }
}