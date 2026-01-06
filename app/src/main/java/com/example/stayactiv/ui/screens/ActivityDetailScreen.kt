package com.example.stayactiv.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stayactiv.data.model.ActivityItem
import com.example.stayactiv.ui.composables.detail.ActivityDetailDescription
import com.example.stayactiv.ui.composables.detail.ActivityDetailHeader
import com.example.stayactiv.ui.composables.detail.ActivityDetailMetadata
import com.example.stayactiv.ui.composables.detail.ActivityDetailRating
import com.example.stayactiv.ui.composables.detail.ActivityDetailWeather
import defaultActivities

@Composable
fun ActivityDetailScreen(
    activity: ActivityItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ActivityDetailHeader(activity)
        ActivityDetailMetadata(activity)
        ActivityDetailRating(activity.rating)
        ActivityDetailDescription(activity.description)
        ActivityDetailWeather(activity.recommendedWeather)
    }
}

@Preview(showBackground = true)
@Composable
fun ActivityDetailScreenPreview() {
    ActivityDetailScreen(
        activity = defaultActivities.first()
    )
}
