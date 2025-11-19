package com.example.snapshotStateListWeather.domain.model

data class SysD(
    val type: Long,
    val id: Long,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
)
