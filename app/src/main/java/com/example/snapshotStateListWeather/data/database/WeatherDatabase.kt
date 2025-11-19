package com.example.snapshotStateListWeather.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myfinalproject.database.WeatherDao

@Database(entities = [Weather::class], version = 2)
abstract class WeatherDatabase:RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}