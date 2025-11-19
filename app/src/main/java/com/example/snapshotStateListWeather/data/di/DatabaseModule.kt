package com.example.snapshotStateListWeather.data.di

import android.content.Context
import androidx.room.Room
import com.example.myfinalproject.database.WeatherDao
import com.example.snapshotStateListWeather.data.database.DBMigrator.MIGRATION_1_2
import com.example.snapshotStateListWeather.data.database.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(@ApplicationContext context: Context): WeatherDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            WeatherDatabase::class.java,
            "rupayan_database"
        ).addMigrations(MIGRATION_1_2).build()
    }

    @Singleton
    @Provides
    fun provideFavoriteMovieDao(db: WeatherDatabase): WeatherDao {
        return db.weatherDao()
    }
}