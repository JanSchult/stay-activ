package com.example.stayactiv.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.stayactiv.util.ActivityCategory
import com.example.stayactiv.util.DifficultyLevel
import com.example.stayactiv.util.WeatherCondition
import java.util.UUID

@Entity(tableName = "activities")
data class ActivityItem(
    @PrimaryKey val id: String = UUID.randomUUID().toString(), // <- UUID als String

    val title: String,
    val description: String? = null,
    val category: ActivityCategory,
    val recommendedWeather: List<WeatherCondition> = listOf(WeatherCondition.ANY),
    val isOutdoor: Boolean = false,
    val difficulty: DifficultyLevel = DifficultyLevel.EASY,
    val isUserCreated: Boolean = false,
    val imageUrl: String? = null,
    val rating: RatingCategory? = null,
    val durationMinutes: Int? = null
)
