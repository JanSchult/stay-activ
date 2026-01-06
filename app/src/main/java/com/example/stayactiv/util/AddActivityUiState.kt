package com.example.stayactiv.util

data class AddActivityUiState(
    val title: String = "",
    val note: String = "",
    val category: ActivityCategory = ActivityCategory.OTHER,
    val durationMinutes: Int? = null,
    val rating: RatingCategory = RatingCategory.THREE_STARS,
    val isSaving: Boolean = false
)
