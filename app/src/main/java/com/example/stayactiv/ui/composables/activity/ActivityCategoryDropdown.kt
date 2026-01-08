package com.example.stayactiv.ui.composables.activity

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.stayactiv.util.ActivityCategory
import com.example.stayactiv.util.WeatherCondition
import com.example.stayactiv.viewmodel.ActivitiesViewModel

@Composable
fun ActivityFilterDropdown(
    viewModel: ActivitiesViewModel,
    selectedCategory: ActivityCategory?,
    currentWeather: WeatherCondition?, // Aktuelles Wetter übergeben
    onCategorySelected: (ActivityCategory?) -> Unit,
    onUseWeather: () -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = modifier) {
        // Button zum Öffnen des Dropdowns
        OutlinedButton(onClick = { expanded = true }) {
            Text(selectedCategory?.name ?: "Alle Kategorien")
            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            // Alle Aktivitäten
            DropdownMenuItem(
                text = { Text("Alle Kategorien") },
                onClick = {
                    onCategorySelected(null)
                    viewModel.disableWeatherFilter() // Wetterfilter deaktivieren
                    expanded = false
                }
            )

            // Wetter-basierte Aktivitäten
            DropdownMenuItem(
                text = { Text("Empfohlen für aktuelles Wetter") },
                onClick = {
                    currentWeather?.let {
                        viewModel.enableWeatherFilter(it) // Filter aktivieren
                    }
                    expanded = false
                }
            )

            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
            // Trennlinie

            // Alle Kategorien
            ActivityCategory.entries.forEach { c ->
                DropdownMenuItem(
                    text = { Text(c.name) },
                    onClick = {
                        onCategorySelected(c)
                        viewModel.disableWeatherFilter() // Wetterfilter deaktivieren
                        expanded = false
                    }
                )
            }
        }
    }
}
