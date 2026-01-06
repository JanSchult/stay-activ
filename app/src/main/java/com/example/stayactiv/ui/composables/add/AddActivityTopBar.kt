package com.example.stayactiv.ui.composables.add

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddActivityTopBar(onCancel: () -> Unit) {
    TopAppBar(
        title = { Text("Neue Aktivität") },
        navigationIcon = {
            IconButton(onClick = onCancel) {
                Icon(Icons.Default.Close, contentDescription = "Abbrechen")
            }
        }
    )
}
