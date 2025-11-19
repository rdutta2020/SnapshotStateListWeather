package com.example.snapshotStateListWeather.data.mapper

import com.example.snapshotStateListWeather.data.entity.Coord
import com.example.snapshotStateListWeather.data.entity.WeatherResult
import com.example.snapshotStateListWeather.data.entity.Sys
import com.example.snapshotStateListWeather.domain.model.CloudsD
import com.example.snapshotStateListWeather.domain.model.CoordD
import com.example.snapshotStateListWeather.domain.model.MainD
import com.example.snapshotStateListWeather.domain.model.RainD
import com.example.snapshotStateListWeather.domain.model.SysD
import com.example.snapshotStateListWeather.domain.model.WeatherD
import com.example.snapshotStateListWeather.domain.model.WeatherResultD
import com.example.snapshotStateListWeather.domain.model.WindD

object WeatherMapper {
    fun mapToWeatherResultD(weatherResult: WeatherResult): WeatherResultD {
        return WeatherResultD(
            coord = mapToCoordD(weatherResult.coord),
            weather = weatherResult.weather.map { weather ->
                WeatherD(
                    id = weather.id,
                    main = weather.main,
                    description = weather.description,
                    icon = weather.icon
                )
            },
            base = weatherResult.base,
            main = MainD(
                temp = weatherResult.main.temp,
                feelsLike = weatherResult.main.feelsLike,
                tempMin = weatherResult.main.tempMin,
                tempMax = weatherResult.main.tempMax,
                pressure = weatherResult.main.pressure,
                humidity = weatherResult.main.humidity,
                seaLevel = weatherResult.main.seaLevel,
                grndLevel = weatherResult.main.grndLevel
            ),
            visibility = weatherResult.visibility,
            wind = WindD(
                speed = weatherResult.wind.speed,
                deg = weatherResult.wind.deg,
                gust = weatherResult.wind.gust
            ),
            rain = RainD(weatherResult.rain.n1h),
            clouds = CloudsD(
                all = weatherResult.clouds.all),
            dt = weatherResult.dt,
            sys = mapToSysD(weatherResult.sys),
            timezone = weatherResult.timezone,
            id = weatherResult.id,
            name = weatherResult.name,
            cod = weatherResult.cod
        )
    }

    fun mapToCoordD(coord: Coord): CoordD {
        return CoordD(
            lon = coord.lon,
            lat = coord.lat
        )
    }

    fun mapToSysD(sys: Sys): SysD {
        return SysD(
            type = sys.type,
            id = sys.id,
            country = sys.country,
            sunrise = sys.sunrise,
            sunset = sys.sunset
        )
    }
}