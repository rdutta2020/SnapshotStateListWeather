package com.example.snapshotStateListWeather.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Rain(
    @SerialName(value = "1h")
    val n1h: Double
)
