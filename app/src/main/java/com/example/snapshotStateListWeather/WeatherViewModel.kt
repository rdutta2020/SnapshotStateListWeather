package com.example.snapshotStateListWeather

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.snapshotStateListWeather.domain.model.CoordD
import com.example.snapshotStateListWeather.domain.model.WeatherResultD
import com.example.snapshotStateListWeather.domain.repository.WeatherRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherRepo: WeatherRepository): ViewModel() {
    val worldCities = listOf(
        CitiesHolder("India", mutableStateListOf(
            City("Pune",  CoordD(73.8567, 18.5204), null, WeatherState.IDLE),
            City("Bengaluru", CoordD(77.5946, 12.9716), null, WeatherState.IDLE),
            City("Hyderabad",  CoordD(78.4772, 17.4065), null, WeatherState.IDLE),
            City("Kolkata",  CoordD(88.3629, 22.5744), null, WeatherState.IDLE),
        )),
        CitiesHolder("America", mutableStateListOf(
            City("Dallas",  CoordD(-96.7970, 32.7767), null, WeatherState.IDLE),
            City("Salisbury", CoordD(-75.605919, 38.363350), null, WeatherState.IDLE),
            City("Houston",  CoordD(-95.358421, 29.749907), null, WeatherState.IDLE),
            City("Philadelphia",  CoordD(-75.1652, 39.9526), null, WeatherState.IDLE),
        )),
        CitiesHolder("Australia", mutableStateListOf(
            City("Sydney",  CoordD(151.2094, -33.8650), null, WeatherState.IDLE),
            City("Melbourne", CoordD(144.9631, -37.8136), null, WeatherState.IDLE),
            City("Brisbane",  CoordD(153.0281, -27.4678), null, WeatherState.IDLE),
            City("Maylands",  CoordD(115.8589, -31.9522), null, WeatherState.IDLE),
        )),
        CitiesHolder("China", mutableStateListOf(
            City("Beijing",  CoordD(116.4074, 39.9042), null, WeatherState.IDLE),
            City("Guangzhou", CoordD(113.2600, 23.1300), null, WeatherState.IDLE),
            City("Gangxia",  CoordD(114.0596, 22.5429), null, WeatherState.IDLE),
            City("Nanjing",  CoordD(118.7667, 32.0499), null, WeatherState.IDLE),
        ))
    )

    fun fetchWeather(countryIndex: Int, cityIndex: Int) {
        val cities = worldCities[countryIndex].cities
        cities[cityIndex] = cities[cityIndex].copy(weatherState = WeatherState.LOADING)
        viewModelScope.launch(Dispatchers.IO) {
            val result = weatherRepo.getWeather(cities[cityIndex].coordinates.lat, cities[cityIndex].coordinates.lon)
            Log.i("WeatherViewModel", "City name ${cities[cityIndex].name} Weather data: $result")
            result?.let {
                cities[cityIndex] = cities[cityIndex].copy(weather = it)
                cities[cityIndex] = cities[cityIndex].copy(weatherState = WeatherState.LOADED)
            }
        }
    }

    enum class WeatherState {
        IDLE,
        LOADING,
        LOADED
    }

    data class City(
        val name: String,
        val coordinates: CoordD,
        val weather: WeatherResultD?, // initially we do not know weather
        val weatherState: WeatherState
    )

    data class CitiesHolder (
        val countryName: String,
        val cities: SnapshotStateList<City>
    )

}