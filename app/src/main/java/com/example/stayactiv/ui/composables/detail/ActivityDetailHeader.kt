package com.example.stayactiv.ui.composables.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.example.stayactiv.data.model.ActivityItem

@Composable
fun ActivityDetailHeader(activity: ActivityItem) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        activity.imageUrl?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = activity.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = activity.title,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = activity.category.name.replace("_", " "),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
