package com.example.snapshotStateListWeather.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.snapshotStateListWeather.R
import com.example.snapshotStateListWeather.WeatherViewModel
import com.example.snapshotStateListWeather.domain.model.CloudsD
import com.example.snapshotStateListWeather.domain.model.CoordD
import com.example.snapshotStateListWeather.domain.model.MainD
import com.example.snapshotStateListWeather.domain.model.RainD
import com.example.snapshotStateListWeather.domain.model.SysD
import com.example.snapshotStateListWeather.domain.model.WeatherD
import com.example.snapshotStateListWeather.domain.model.WeatherResultD
import com.example.snapshotStateListWeather.domain.model.WindD
import com.example.snapshotStateListWeather.ngwidget.ShowProgressBar
import com.example.snapshotStateListWeather.ui.theme.GlideImage

@Composable
fun WeatherItem(city: WeatherViewModel.City) {
    ElevatedCard(
        modifier = Modifier
            .padding(8.dp)
            .width(260.dp)
            .height(180.dp)
            .background(Color.Transparent)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if(city.weatherState == WeatherViewModel.WeatherState.LOADED) {
                GlideImage(
                    url = "android.resource://com.example.snapshotStateListWeather/" + getDrawable(city.weather!!.name),
                    contentDescription = city.weather!!.name,
                    modifier = Modifier.fillMaxSize()
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = city.weather!!.name,
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.Green,
                        modifier = Modifier
                    )
                    Text(
                        text = String.format("%.2f", city.weather!!.main.temp - 273.15),
                        style = MaterialTheme.typography.headlineLarge,
                        color = Color.Green,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }else{
                ShowProgressBar()
            }
        }
    }
}

fun getDrawable(city: String):Int{
    if (city == "Hyderabad") return R.drawable.hyderabad
    if (city == "Pune") return R.drawable.pune
    if (city == "Bengaluru") return R.drawable.bengaluru
    if (city == "Kolkata") return R.drawable.kolkata

    if (city == "Sydney") return R.drawable.sydney
    if (city == "Melbourne") return R.drawable.melbourne
    if (city == "Brisbane") return R.drawable.brisbane
    if (city == "Maylands") return R.drawable.maylands

    if (city == "Beijing") return R.drawable.beijing
    if (city == "Guangzhou") return R.drawable.guangzhou
    if (city == "Gangxia") return R.drawable.gangxia
    if (city == "Nanjing") return R.drawable.nanjing

    if (city == "Dallas") return R.drawable.dallas
    if (city == "Salisbury") return R.drawable.salisbury
    if (city == "Houston") return R.drawable.houston
    if (city == "Philadelphia") return R.drawable.philadelphia
    return R.drawable.philadelphia
}

@Preview(showBackground = true)
@Composable
fun WeatherItemPreview() {
    val sampleWeather = WeatherResultD(
        coord = CoordD(0.0, 0.0),
        weather = listOf(WeatherD(1, "clear sky", "01d", "")),
        base = "stations",
        main = MainD(
            temp = 25.0,
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
        clouds = CloudsD(10),
        dt = 1633036800,
        sys = SysD(type = 1, id = 1234, country = "IN", sunrise = 1632987600, sunset = 1633030800),
        timezone = 19800,
        id = 1275004,
        name = "Kolkata",
        cod = 200
    )
}

fun createDummyWeatherResultD(): WeatherResultD {
    return WeatherResultD(
        coord = CoordD(lat = 0.0, lon = 0.0),
        weather = listOf(WeatherD(id = 1, main = "Clear", description = "clear sky", icon = "01d")),
        base = "stations",
        main = MainD(
            temp = 300.0,
            feelsLike = 303.0,
            tempMin = 298.0,
            tempMax = 305.0,
            pressure = 1013,
            humidity = 50,
            seaLevel = 1013,
            grndLevel = 1013
        ),
        visibility = 10000,
        wind = WindD(speed = 5.0, deg = 180, gust = 7.0),
        rain = RainD(n1h = 0.0),
        clouds = CloudsD(all = 0),
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
        name = "Dummy City",
        cod = 200
    )
}