package com.example.stayactiv.ui.composables.add

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ActivityNoteInput(
    note: String,
    onNoteChange: (String) -> Unit
) {
    OutlinedTextField(
        value = note,
        onValueChange = onNoteChange,
        label = { Text("Notiz (optional)") },
        modifier = Modifier.fillMaxWidth(),
        minLines = 3
    )
}
