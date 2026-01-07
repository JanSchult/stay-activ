package com.example.stayactiv.ui.composables.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.stayactiv.R
import com.example.stayactiv.util.RatingCategory
import com.example.stayactiv.util.stars

@Composable
fun ActivityDetailRating(rating: RatingCategory?) {
    Column {
        Text("Bewertung", style = MaterialTheme.typography.titleSmall)

        val ratingStars: Any = rating?.stars() ?: 0

        Row {
            RatingCategory.entries.forEach { r ->
                Icon(
                    painter = painterResource(
                        if (r.stars() <= ratingStars as String)
                            R.drawable.baseline_star_24
                        else
                            R.drawable.outline_star_24
                    ),
                    contentDescription = null
                )
            }
        }
    }
}
