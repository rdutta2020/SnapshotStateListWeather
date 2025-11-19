package com.example.snapshotStateListWeather.domain.repository

import com.example.snapshotStateListWeather.domain.model.WeatherResultD


interface WeatherRepository{
    suspend fun getWeather(lat: Double, lon: Double) : WeatherResultD?
}