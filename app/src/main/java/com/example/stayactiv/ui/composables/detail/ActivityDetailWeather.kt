package com.example.stayactiv.ui.composables.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AssistChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.stayactiv.util.WeatherCondition

@Composable
fun ActivityDetailWeather(
    weather: List<WeatherCondition>
) {
    Column {
        Text("Empfohlenes Wetter", style = MaterialTheme.typography.titleSmall)

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            weather.forEach {
                AssistChip(
                    onClick = {},
                    label = { Text(it.name.replace("_", " ")) }
                )
            }
        }
    }
}
