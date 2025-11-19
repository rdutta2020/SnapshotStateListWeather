package com.example.myfinalproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.snapshotStateListWeather.data.database.Weather

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: Weather)

    @Query("SELECT * FROM weather WHERE lat = :lat AND lon = :lon")
    fun getWeather(lat: Double, lon: Double): Weather?

    @Query("DELETE FROM weather WHERE lat = :lat AND lon = :lon")
    suspend fun delete(lat: Double, lon: Double)
}