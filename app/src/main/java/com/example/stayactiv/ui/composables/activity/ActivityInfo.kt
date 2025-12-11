package com.example.stayactiv.ui.composables.activity

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.stayactiv.data.model.ActivityItem

@Composable
fun ActivityInfo(activity: ActivityItem) {
    Column(modifier = Modifier.padding(8.dp)) {
        ActivityTitle(title = activity.title)
        ActivityDescription(description = activity.description ?: "")
        Spacer(modifier = Modifier.height(4.dp))
        ActivityMetadata(activity = activity)
    }
}