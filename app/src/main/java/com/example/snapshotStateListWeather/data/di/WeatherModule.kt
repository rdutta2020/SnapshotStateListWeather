package com.example.snapshotStateListWeather.data.di

import com.example.snapshotStateListWeather.data.service.WeatherAPI
import com.example.snapshotStateListWeather.data.repository.WeatherRepositoryImpl
import com.example.snapshotStateListWeather.domain.repository.WeatherRepository
import com.example.snapshotStateListWeather.network.WeatherRetrofit
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

/**
 * Channels module
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class WeatherModule {

    @Binds
    abstract fun bindWeatherRepository(
        weatherRepository: WeatherRepositoryImpl
    ): WeatherRepository

    companion object {
        /**
         * Provides Retrofit for WeatherAPI Api.
         */
        @Provides
        fun provideWeatherApi(
            @WeatherRetrofit retrofit: Retrofit
        ): WeatherAPI {
            return retrofit.create(WeatherAPI::class.java)
        }
    }
}