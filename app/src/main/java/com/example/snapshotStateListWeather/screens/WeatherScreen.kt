package com.example.snapshotStateListWeather.screens

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.snapshotStateListWeather.WeatherViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WeatherScreen() {
    val weatherViewModel: WeatherViewModel = hiltViewModel()
    LazyColumn {
        itemsIndexed(weatherViewModel.worldCities) { countryIndex, cityHolder ->
            Text(
                text = cityHolder.countryName,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow {
                itemsIndexed(weatherViewModel.worldCities[countryIndex].cities) { cityIndex, city ->
                    val state = city.weatherState
                    Log.i(
                        "HomeScreen",
                        "City name ${city.name} Weather state: $state Weather Result ${city.weather}"
                    )
                    LaunchedEffect(Unit) { // ask point
                        // if (state == WeatherViewModel.WeatherState.IDLE) {
                        weatherViewModel.fetchWeather(countryIndex, cityIndex)
                        //}
                    }
                    WeatherItem(city)
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(25.dp))
        }
    }
}


