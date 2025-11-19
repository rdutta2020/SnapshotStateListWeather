package com.example.snapshotStateListWeather.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Wind(
    val speed: Double,
    val deg: Long,
    val gust: Double = 0.0, // Default value
)
