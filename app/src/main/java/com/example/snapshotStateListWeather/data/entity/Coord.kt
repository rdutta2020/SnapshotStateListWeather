package com.example.snapshotStateListWeather.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class Coord(
    val lon: Double,
    val lat: Double,
)
