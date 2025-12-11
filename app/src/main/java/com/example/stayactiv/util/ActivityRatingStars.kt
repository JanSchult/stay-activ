package com.example.stayactiv.util

fun RatingCategory.stars(): String = when (this) {
    RatingCategory.ONE_STAR -> "★☆☆☆☆"
    RatingCategory.TWO_STARS -> "★★☆☆☆"
    RatingCategory.THREE_STARS -> "★★★☆☆"
    RatingCategory.FOUR_STARS -> "★★★★☆"
    RatingCategory.FIVE_STARS -> "★★★★★"
}
