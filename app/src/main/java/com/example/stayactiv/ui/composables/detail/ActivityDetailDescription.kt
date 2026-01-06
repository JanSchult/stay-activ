package com.example.stayactiv.ui.composables.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ActivityDetailDescription(description: String?) {
    if (!description.isNullOrBlank()) {
        Column {
            Text("Beschreibung", style = MaterialTheme.typography.titleSmall)
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
