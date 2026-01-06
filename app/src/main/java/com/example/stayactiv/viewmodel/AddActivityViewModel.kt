package com.example.stayactiv.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stayactiv.data.model.ActivityItem
import com.example.stayactiv.data.repository.ActivityRepository
import com.example.stayactiv.util.ActivityCategory
import com.example.stayactiv.util.AddActivityUiState
import com.example.stayactiv.util.RatingCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class AddActivityViewModel(
    private val repository: ActivityRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddActivityUiState())
    val uiState: StateFlow<AddActivityUiState> = _uiState

    fun onTitleChange(value: String) {
        _uiState.update { it.copy(title = value) }
    }

    fun onNoteChange(value: String) {
        _uiState.update { it.copy(note = value) }
    }

    fun onCategoryChange(category: ActivityCategory) {
        _uiState.update { it.copy(category = category) }
    }

    fun onDurationChange(minutes: Int?) {
        _uiState.update { it.copy(durationMinutes = minutes) }
    }

    fun onRatingChange(rating: RatingCategory) {
        _uiState.update { it.copy(rating = rating) }
    }

    fun onSave() {
        viewModelScope.launch {
            val state = uiState.value

            if (state.title.isBlank()) return@launch

            _uiState.update { it.copy(isSaving = true) }

            val activity = ActivityItem(
                id = UUID.randomUUID().toString(),
                title = state.title,
                description = state.note,
                category = state.category,
                durationMinutes = state.durationMinutes,
                rating = state.rating,
                isUserCreated = true,
                imageUrl = null
            )

            repository.addActivity(activity)

            _uiState.update { AddActivityUiState() } // Reset nach Save
        }
    }
}
