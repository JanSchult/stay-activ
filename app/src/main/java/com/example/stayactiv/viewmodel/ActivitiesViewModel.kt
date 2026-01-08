package com.example.stayactiv.viewmodel

import android.R.attr.enabled
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stayactiv.data.model.ActivityItem
import com.example.stayactiv.data.repository.ActivityRepository
import com.example.stayactiv.util.ActivityCategory
import com.example.stayactiv.util.AddActivityUiState
import com.example.stayactiv.util.RatingCategory
import com.example.stayactiv.util.WeatherCondition
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class ActivitiesViewModel(
    private val repository: ActivityRepository
) : ViewModel() {

    /* ---------------- FILTER STATES ---------------- */

    // Kategorie-Filter (null = alle)
    private val _categoryFilter = MutableStateFlow<ActivityCategory?>(null)
    val categoryFilter: StateFlow<ActivityCategory?> = _categoryFilter

    // Wetterfilter EIN / AUS
    private val _useWeatherFilter = MutableStateFlow(false)
    val useWeatherFilter: StateFlow<Boolean> = _useWeatherFilter

    // Aktuelles Wetter (vom WeatherViewModel gesetzt)
    private val _currentWeather = MutableStateFlow<WeatherCondition?>(null)
    val currentWeather: StateFlow<WeatherCondition?> = _currentWeather

    /* ---------------- DATA ---------------- */

    val activities: StateFlow<List<ActivityItem>> =
        repository.getAllActivities()
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                emptyList()
            )

    /* ---------------- FILTERED LIST ---------------- */

    val filteredActivities: StateFlow<List<ActivityItem>> =
        combine(
            activities,
            categoryFilter,
            useWeatherFilter,
            currentWeather
        ) { activities, category,useWeatherFilter, weather ->

            Log.d(
                "ActivitiesViewModel",
                "Filtering: category=$category, weather=$weather,useWeatherFilter=$useWeatherFilter ,total=${activities.size}"
            )

            val result = activities.filter { activity ->

                if (useWeatherFilter == false) {
                    val categoryMatches =
                        category == null || activity.category == category
                    categoryMatches
                }else {
                    val weatherMatches =
                        weather == null ||
                                activity.recommendedWeather.contains(weather)
                    return@filter weatherMatches
                }
            }

            Log.d(
                "ActivitiesViewModel",
                "Result size = ${result.size}"
            )

            result
        }
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                emptyList()
            )

    /* ---------------- FILTER ACTIONS ---------------- */

    fun onCategoryFilterChange(category: ActivityCategory?) {
        _categoryFilter.value = category
    }

    fun enableWeatherFilter(weather: WeatherCondition) {
        _useWeatherFilter.value = true
        _currentWeather.value = weather

        Log.d(
            "ActivitiesViewModel",
            "Weather filter enabled = true, currentWeather = $weather"
        )
    }
    fun disableWeatherFilter() {
        _useWeatherFilter.value = false
        _currentWeather.value = null
    }

    fun setCurrentWeather(weather: WeatherCondition?) {
        _currentWeather.value = weather
        Log.d(
            "ActivitiesViewModel",
            "Weather filter enabled = $enabled, currentWeather = ${_currentWeather.value}"
        )
    }

    /* ---------------- DETAIL ---------------- */

    fun getActivityById(id: String): ActivityItem? {
        return activities.value.firstOrNull { it.id == id }
    }

    /* ---------------- ADD ACTIVITY ---------------- */

    private val _addUiState = MutableStateFlow(AddActivityUiState())
    val addUiState: StateFlow<AddActivityUiState> = _addUiState

    fun onTitleChange(title: String) {
        _addUiState.update { it.copy(title = title) }
    }

    fun onCategoryChange(category: ActivityCategory) {
        _addUiState.update { it.copy(category = category) }
    }

    fun onDurationChange(duration: Int?) {
        _addUiState.update { it.copy(durationMinutes = duration) }
    }

    fun onRatingChange(rating: RatingCategory) {
        _addUiState.update { it.copy(rating = rating) }
    }

    fun onNoteChange(note: String) {
        _addUiState.update { it.copy(note = note) }
    }

    fun saveActivity() {
        val state = _addUiState.value
        if (state.title.isBlank()) return

        val newActivity = ActivityItem(
            id = UUID.randomUUID().toString(),
            title = state.title,
            description = state.note,
            category = state.category,
            durationMinutes = state.durationMinutes,
            rating = state.rating,
            recommendedWeather = listOf(WeatherCondition.ANY),
            isOutdoor = true,
            isUserCreated = true,
            imageUrl = null
        )

        viewModelScope.launch {
            repository.insert(newActivity)
            resetAddState()
        }
    }

    private fun resetAddState() {
        _addUiState.value = AddActivityUiState()
    }
}
