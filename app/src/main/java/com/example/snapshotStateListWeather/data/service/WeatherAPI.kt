package com.example.snapshotStateListWeather.data.service

import com.example.snapshotStateListWeather.data.entity.WeatherResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    // Define the API endpoints here

    @GET("weather")
    suspend fun getWeatherResult(@Query("lat") lat: Double, @Query("lon") lon: Double, @Query("appid") apiKey: String): Response<WeatherResult>
}