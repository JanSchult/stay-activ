package com.example.stayactiv.data.model

import com.example.stayactiv.util.WeatherCondition



object WeatherCodeMapper {

    fun toCondition(code: Int): WeatherCondition {
        return when (code) {
            0 -> WeatherCondition.SUNNY              // klar
            1, 2 -> WeatherCondition.CLOUDY          // leicht bis teilweise bewölkt
            3 -> WeatherCondition.CLOUDY             // stark bewölkt

            51, 53, 55 -> WeatherCondition.RAINY     // Nieselregen
            61, 63, 65 -> WeatherCondition.RAINY     // Regen
            80, 81, 82 -> WeatherCondition.RAINY     // Schauer

            71, 73, 75 -> WeatherCondition.SNOWY     // Schnee
            77 -> WeatherCondition.SNOWY             // Schneekristalle
            85, 86 -> WeatherCondition.SNOWY         // Schneeschauer

            else -> WeatherCondition.ANY
        }
    }

    fun toDescription(code: Int): String {
        return when (code) {
            0 -> "Klarer Himmel"
            1 -> "Überwiegend klar"
            2 -> "Teilweise bewölkt"
            3 -> "Bewölkt"

            51 -> "Leichter Nieselregen"
            53 -> "Mäßiger Nieselregen"
            55 -> "Starker Nieselregen"

            61 -> "Leichter Regen"
            63 -> "Regen"
            65 -> "Starker Regen"

            71 -> "Leichter Schneefall"
            73 -> "Schneefall"
            75 -> "Starker Schneefall"

            80 -> "Leichte Regenschauer"
            81 -> "Regenschauer"
            82 -> "Heftige Regenschauer"

            85 -> "Leichte Schneeschauer"
            86 -> "Schneeschauer"

            else -> "Unbekannte Wetterlage"
        }
    }
}
