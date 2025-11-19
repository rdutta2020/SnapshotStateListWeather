package com.example.snapshotStateListWeather.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sys(
    @SerialName(value = "type")
    val type: Long = 0L,
    @SerialName(value = "id")
    val id: Long = 0L,
    @SerialName(value = "country")
    val country: String = "",
    @SerialName(value = "sunrise")
    val sunrise: Long,
    @SerialName(value = "sunset")
    val sunset: Long
)
