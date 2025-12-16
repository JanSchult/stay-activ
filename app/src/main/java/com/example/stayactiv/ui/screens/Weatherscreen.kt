package com.example.stayactiv.ui.screens

import WeatherViewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stayactiv.data.model.WeatherToday
import com.example.stayactiv.data.model.WeatherTomorrow
import com.example.stayactiv.ui.composables.weather.WeatherContent
import com.example.stayactiv.util.WeatherCondition
import com.example.stayactiv.util.WeatherUiState

@Composable
fun WeatherScreen(
    state: WeatherUiState,
    onRetry: () -> Unit
) {
    when {

        state.isLoading -> {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        state.errorMessage != null -> {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(state.errorMessage)
                    Spacer(Modifier.height(16.dp))
                    Button(onClick = onRetry) {
                        Text("Erneut versuchen")
                    }
                }
            }
        }

        else -> {
            state.today?.let { today ->
                state.tomorrow?.let { tomorrow ->
                    WeatherContent(today, tomorrow)
                }
            }
        }
    }
}