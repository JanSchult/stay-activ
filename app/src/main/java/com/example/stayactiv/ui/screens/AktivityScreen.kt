package com.example.stayactiv.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.stayactiv.data.model.ActivityItem
import com.example.stayactiv.ui.composables.activity.ActivityCard
import com.example.stayactiv.ui.composables.activity.ActivityFilterDropdown
import com.example.stayactiv.util.WeatherCondition
import com.example.stayactiv.viewmodel.ActivitiesViewModel

@Composable
fun ActivityScreen(
    viewModel: ActivitiesViewModel,
    currentWeather: WeatherCondition?,
    onAdd: () -> Unit,
    onClick: (ActivityItem) -> Unit
) {
    val activities by viewModel.filteredActivities.collectAsState()
    val selectedCategory by viewModel.categoryFilter.collectAsState()

    // Wenn der Parent die aktuelle Wetterbedingung liefert, setzen wir sie (automatic)
    LaunchedEffect(currentWeather) {
        // currentWeather kann null sein -> entfernt den Wetterfilter
        viewModel.setCurrentWeather(currentWeather)
    }

    Column {
        ActivityFilterDropdown(
            selectedCategory = selectedCategory,
            onCategorySelected = { viewModel.onCategoryFilterChange(it) },
            onUseWeather = {
                // Wenn user "Empfohlen für aktuelles Wetter" wählt, ist currentWeather schon gesetzt durch LaunchedEffect
                // Alternativ könnte man explizit viewModel.updateWeatherFilter(currentWeather) aufrufen
                viewModel.setCurrentWeather(currentWeather)
            },
            viewModel = viewModel,
            modifier = Modifier,
            currentWeather = currentWeather
        )

        Spacer(Modifier.height(8.dp))

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(contentPadding = PaddingValues(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(activities, key = { it.id }) { activity ->
                    ActivityCard(activity = activity, onClick = { onClick(activity) })
                }
            }

            FloatingActionButton(onClick = onAdd, modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp)) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    }
}
