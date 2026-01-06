package com.example.stayactiv.ui.composables.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.stayactiv.util.ActivityCategory

@Composable
fun ActivityCategoryPicker(
    selected: ActivityCategory,
    onCategorySelected: (ActivityCategory) -> Unit
) {
    Column {
        Text("Kategorie", style = MaterialTheme.typography.titleSmall)

        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            ActivityCategory.entries.forEach { category ->
                FilterChip(
                    selected = category == selected,
                    onClick = { onCategorySelected(category) },
                    label = { Text(category.name.lowercase().replaceFirstChar { it.uppercase() }) }
                )
            }
        }
    }
}
