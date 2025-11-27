package com.example.stayactiv.util

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromWeatherList(list: List<WeatherCondition>): String =
        list.joinToString(",") { it.name }

    @TypeConverter
    fun toWeatherList(data: String): List<WeatherCondition> =
        if (data.isEmpty()) emptyList()
        else data.split(",").map { WeatherCondition.valueOf(it) }

    @TypeConverter
    fun fromActivityCategory(category: ActivityCategory) = category.name

    @TypeConverter
    fun toActivityCategory(name: String) = ActivityCategory.valueOf(name)

    @TypeConverter
    fun fromDifficulty(difficulty: DifficultyLevel) = difficulty.name

    @TypeConverter
    fun toDifficulty(name: String) = DifficultyLevel.valueOf(name)

    @TypeConverter
    fun fromRating(rating: RatingCategory) = rating.name

    @TypeConverter
    fun toRating(name: String) = RatingCategory.valueOf(name)
}
