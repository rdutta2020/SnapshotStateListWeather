package com.example.snapshotStateListWeather.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.myfinalproject.database.WeatherDao
import com.example.snapshotStateListWeather.data.database.Weather
import com.example.snapshotStateListWeather.data.service.WeatherAPI
import com.example.snapshotStateListWeather.data.mapper.WeatherMapper.mapToWeatherResultD
import com.example.snapshotStateListWeather.domain.model.CloudsD
import com.example.snapshotStateListWeather.domain.model.CoordD
import com.example.snapshotStateListWeather.domain.model.MainD
import com.example.snapshotStateListWeather.domain.model.RainD
import com.example.snapshotStateListWeather.domain.model.SysD
import com.example.snapshotStateListWeather.domain.model.WeatherResultD
import com.example.snapshotStateListWeather.domain.model.WindD
import com.example.snapshotStateListWeather.domain.repository.WeatherRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherAPI: WeatherAPI,
    private val weatherDao: WeatherDao,
    @ApplicationContext private val context: Context
) : WeatherRepository {
    // Implement the methods defined in the WeatherRepository interface
    override suspend fun getWeather(lat: Double, lon: Double): WeatherResultD? {
        if (isNetworkAvailable(context)) {
            // Call the API and return the result
            val response = weatherAPI.getWeatherResult(lat, lon, "b883aa887308e48f122a4692f679da17")
            if (response.isSuccessful) {
                return response.body()?.let { body ->
                    // Save the weather data to the database
                    weatherDao.insert(Weather(
                        lat = lat,
                        lon = lon,
                        temperature = body.main.temp,
                        name = body.name
                    ))
                    // return the mapped result
                    mapToWeatherResultD(body)
                }
            } else {
                // Handle the error case
                return null
            }
        } else {
            // If network is not available, fetch from the database
            val weather = weatherDao.getWeather(lat, lon)
            return if (weather != null) {
                createWeatherResultD(weather)
            } else {
                null
            }
        }
    }

    private fun createWeatherResultD(weather: Weather): WeatherResultD {
        return WeatherResultD(
            coord = CoordD(weather.lon, weather.lat),
            weather = emptyList(),
            base = "stations",
            main = MainD(
                temp = weather.temperature,
                feelsLike = 25.0,
                tempMin = 20.0,
                tempMax = 30.0,
                pressure = 1013,
                humidity = 60,
                seaLevel = 1013,
                grndLevel = 1013
            ),
            visibility = 10000,
            wind = WindD(speed = 5.0, deg = 180, gust = 7.0),
            rain = RainD(1.0),
            clouds = CloudsD(all = 10),
            dt = 1633036800,
            sys = SysD(
                type = 1,
                id = 1234,
                country = "IN",
                sunrise = 1632987600,
                sunset = 1633030800
            ),
            timezone = 19800,
            id = 1275004,
            name = weather.name,
            cod = 200
        )
    }


    private fun isNetworkAvailable(context: Context) : Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)  as ConnectivityManager;
        return connectivityManager.activeNetwork?.let {
            connectivityManager.getNetworkCapabilities(it)?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        } ?: false
    }

}