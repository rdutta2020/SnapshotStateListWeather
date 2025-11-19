package com.example.snapshotStateListWeather.domain.model

data class WeatherResultD(
    val coord: CoordD,
    val weather: List<WeatherD>,
    val base: String,
    val main: MainD,
    val visibility: Long,
    val wind: WindD,
    val rain: RainD,
    val clouds: CloudsD,
    val dt: Long,
    val sys: SysD,
    val timezone: Long,
    val id: Long,
    var name: String,
    val cod: Long,
)