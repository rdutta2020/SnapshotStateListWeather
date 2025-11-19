package com.example.snapshotStateListWeather.domain.model


data class MainD(
    var temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val pressure: Long,
    val humidity: Long,
    val seaLevel: Long,
    val grndLevel: Long,
)
