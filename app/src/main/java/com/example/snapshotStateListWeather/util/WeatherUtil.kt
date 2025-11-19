package com.example.snapshotStateListWeather.util

import com.example.snapshotStateListWeather.domain.model.CoordD

object WeatherUtil {
    fun getCoordinateFromCityName(cityName: String): CoordD {
        return when (cityName) {
            "Pune" -> CoordD(73.8567, 18.5204)
            "Bengaluru" -> CoordD(77.5946, 12.9716)
            "Hyderabad" -> CoordD(78.4772, 17.4065)
            "Kolkata" -> CoordD(88.3629, 22.5744)
            "Dallas" -> CoordD(-96.7970, 32.7767)
            "Salisbury" -> CoordD(-75.605919, 38.363350)
            "Houston" -> CoordD(-95.358421, 29.749907)
            "Philadelphia" -> CoordD(-75.1652, 39.9526)
            "Sydney" -> CoordD(151.2094, -33.8650)
            "Melbourne" -> CoordD(144.9631, -37.8136)
            "Brisbane" -> CoordD(153.0281, -27.4678)
            "Maylands" -> CoordD(115.8589, -31.9522)
            "Beijing" -> CoordD(116.4074, 39.9042)
            "Guangzhou" -> CoordD(113.2600, 23.1300)
            "Gangxia" -> CoordD(114.0596, 22.5429)
            "Nanjing" -> CoordD(118.7667, 32.0499)
            else -> CoordD(118.7667, 32.0499)
        }
    }
}