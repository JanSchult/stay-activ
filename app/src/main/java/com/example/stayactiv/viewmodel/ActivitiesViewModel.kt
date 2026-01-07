package com.example.stayactiv.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stayactiv.data.model.ActivityItem
import com.example.stayactiv.data.repository.ActivityRepository
import com.example.stayactiv.util.ActivityCategory
import com.example.stayactiv.util.AddActivityUiState
import com.example.stayactiv.util.RatingCategory
import com.example.stayactiv.util.WeatherCondition
import defaultActivities
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class ActivitiesViewModel(
    private val repository: ActivityRepository
) : ViewModel() {

    // --- 1️⃣ Alle Aktivitäten ---
    val activities: StateFlow<List<ActivityItem>> =
        repository.getAllActivities()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList()
            )
    init {
        viewModelScope.launch {
            if (repository.getCount() == 0) {
                defaultActivities.forEach { repository.insert(it) }
            }
        }
    }

    // --- 2️⃣ Detail: Activity nach ID ---
    fun getActivityById(id: String): ActivityItem? {
        return activities.value.firstOrNull { it.id == id }
    }

    // --- 3️⃣ AddActivity UI State ---
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

    // --- 4️⃣ Aktivität speichern ---
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
