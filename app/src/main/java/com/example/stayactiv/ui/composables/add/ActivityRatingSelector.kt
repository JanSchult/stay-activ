package com.example.stayactiv.ui.composables.add

import android.media.Rating
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.stayactiv.R
import com.example.stayactiv.util.RatingCategory
import com.example.stayactiv.util.stars

@Composable
fun ActivityRatingSelector(
    rating: RatingCategory,
    onRatingChange: (RatingCategory) -> Unit
) {
    Column {
        Text(
            text = "Bewertung",
            style = MaterialTheme.typography.titleSmall
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            RatingCategory.entries.forEach { r ->
                IconButton(onClick = { onRatingChange(r) }) {
                    Icon(
                        painter = painterResource(
                            id = if (r.stars() <= rating.stars())
                                R.drawable.outline_star_24
                            else
                                R.drawable.baseline_star_24
                        ),
                        contentDescription = "${r.stars()} Sterne"
                    )
                }
            }
        }
    }
}
