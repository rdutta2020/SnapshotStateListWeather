package com.example.snapshotStateListWeather.data.database

import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "weather",
    primaryKeys = ["lat", "lon"],
    indices = [Index(value = ["lat", "lon"], unique = true)]
)
data class Weather(
    val lat: Double,
    val lon: Double,
    val temperature: Double,
    val name: String
)