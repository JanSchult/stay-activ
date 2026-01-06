package com.example.stayactiv.ui.composables.weather

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.stayactiv.R


@Composable
fun SunriseSunsetCard(
    sunrise: String,
    sunset: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "Sonne",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                SunTimeItem(
                    iconRes = R.drawable.outline_wb_sunny_24, // Sonnenaufgang
                    label = "Sonnenaufgang",
                    time = sunrise
                )

                SunTimeItem(
                    iconRes = R.drawable.outline_nightlight_24, // Sonnenuntergang
                    label = "Sonnenuntergang",
                    time = sunset
                )
            }
        }
    }
}