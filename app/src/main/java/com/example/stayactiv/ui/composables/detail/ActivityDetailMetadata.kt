package com.example.stayactiv.ui.composables.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.stayactiv.R
import com.example.stayactiv.data.model.ActivityItem

@Composable
fun ActivityDetailMetadata(activity: ActivityItem) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        activity.durationMinutes?.let {
            DetailChip(
                icon = R.drawable.outline_timer_24,
                text = "$it Minuten"
            )
        }

        if (activity.isUserCreated) {
            DetailChip(
                icon = R.drawable.outline_person_24,
                text = "Eigene Aktivität"
            )
        }
    }
}
