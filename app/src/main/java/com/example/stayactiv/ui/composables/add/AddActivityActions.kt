package com.example.stayactiv.ui.composables.add

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddActivityActions(onSave: () -> Unit) {
    Button(
        onClick = onSave,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Aktivität speichern")
    }
}
