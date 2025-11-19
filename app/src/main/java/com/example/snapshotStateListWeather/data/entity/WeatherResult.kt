package com.example.snapshotStateListWeather.data.entity

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResult(
    val coord: Coord,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Long,
    val wind: Wind,
    val rain: Rain = Rain(0.0),
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Long,
)