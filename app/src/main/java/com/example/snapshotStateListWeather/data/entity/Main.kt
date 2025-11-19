package com.example.snapshotStateListWeather.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Main(
    @SerialName(value = "temp")
    val temp: Double,
    @SerialName(value = "feels_like")
    val feelsLike: Double,
    @SerialName(value = "temp_min")
    val tempMin: Double,
    @SerialName(value = "temp_max")
    val tempMax: Double,
    @SerialName(value = "pressure")
    val pressure: Long,
    @SerialName(value = "humidity")
    val humidity: Long,
    @SerialName(value = "sea_level")
    val seaLevel: Long,
    @SerialName(value = "grnd_level")
    val grndLevel: Long
)
