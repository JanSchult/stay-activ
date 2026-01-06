package com.example.stayactiv.ui.composables.weather

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SunTimeItem(
    @DrawableRes iconRes: Int,
    label: String,
    time: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = label,
            modifier = Modifier.size(28.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = time,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
    }
}