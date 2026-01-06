package com.example.stayactiv.ui.composables.add

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ActivityTitleInput(
    title: String,
    onTitleChange: (String) -> Unit
) {
    OutlinedTextField(
        value = title,
        onValueChange = onTitleChange,
        label = { Text("Aktivität") },
        modifier = Modifier.fillMaxWidth()
    )
}
