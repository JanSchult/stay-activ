package com.example.stayactiv.ui.composables.detail

import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun DetailChip(
    icon: Int,
    text: String
) {
    AssistChip(
        onClick = {},
        leadingIcon = {
            Icon(
                painter = painterResource(icon),
                contentDescription = null
            )
        },
        label = { Text(text) }
    )
}
