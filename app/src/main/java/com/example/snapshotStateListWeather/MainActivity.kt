package com.example.snapshotStateListWeather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.snapshotStateListWeather.screens.WeatherScreen
import com.example.snapshotStateListWeather.ui.theme.SnapshotStateListWeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SnapshotStateListWeatherAppTheme {
                WeatherScreen()
            }
        }
    }
}

