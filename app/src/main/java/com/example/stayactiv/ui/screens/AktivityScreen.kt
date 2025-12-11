package com.example.stayactiv.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stayactiv.data.model.ActivityItem
import com.example.stayactiv.ui.composables.activity.ActivityCard
import defaultActivities

@Composable
fun ActivityScreen(
    activities: List<ActivityItem>,
    onActivityClick: (ActivityItem) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(activities) { activity ->
            ActivityCard(activity = activity, onClick = { onActivityClick(activity) })
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ActivityScreenPreview() {
    ActivityScreen(
        activities = defaultActivities,
        onActivityClick = {} // Keine Aktion für Preview
    )
}