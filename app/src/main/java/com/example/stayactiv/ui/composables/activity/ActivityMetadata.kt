package com.example.stayactiv.ui.composables.activity

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.stayactiv.data.model.ActivityItem
import com.example.stayactiv.util.stars

@Composable
fun ActivityMetadata(activity: ActivityItem) {
    Text(
        text = "Kategorie: ${activity.category}",
        style = MaterialTheme.typography.bodySmall
    )
    Text(
        text = "Dauer: ${activity.durationMinutes ?: "n/a"} Min",
        style = MaterialTheme.typography.bodySmall
    )
    Text(
        text = "Bewertung: ${activity.rating?.stars()}",
        style = MaterialTheme.typography.bodySmall
    )
}