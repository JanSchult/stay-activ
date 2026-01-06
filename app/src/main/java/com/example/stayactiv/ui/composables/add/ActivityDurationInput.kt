package com.example.stayactiv.ui.composables.add

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun ActivityDurationInput(
    durationMinutes: Int?,
    onDurationChange: (Int?) -> Unit
) {
    OutlinedTextField(
        value = durationMinutes?.toString() ?: "",
        onValueChange = {
            onDurationChange(it.toIntOrNull())
        },
        label = { Text("Dauer (Minuten)") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}
