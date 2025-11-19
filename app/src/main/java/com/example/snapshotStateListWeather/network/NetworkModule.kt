    package com.example.snapshotStateListWeather.network

    import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
    import dagger.Module
    import dagger.Provides
    import dagger.hilt.InstallIn
    import dagger.hilt.components.SingletonComponent
    import retrofit2.Converter
    import retrofit2.Retrofit
    import kotlinx.serialization.json.Json
    import javax.inject.Qualifier
    import javax.inject.Singleton

    import okhttp3.MediaType.Companion.toMediaType
    import okhttp3.OkHttpClient
    import okhttp3.logging.HttpLoggingInterceptor


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class KotlinxSerializationFactory

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class WeatherRetrofit

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class NewsRetrofit

    @Module
    @InstallIn(SingletonComponent::class)
    class NetworkModule {

        @Singleton
        @Provides
        @WeatherRetrofit
        fun provideWeatherRetrofit(@KotlinxSerializationFactory kotlinxSerializationFactory: Converter.Factory):Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(kotlinxSerializationFactory)
                .build()
        }

        @Singleton
        @Provides
        @NewsRetrofit
        fun provideNewsRetrofit(@KotlinxSerializationFactory kotlinxSerializationFactory: Converter.Factory):Retrofit {
            val logging = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://api.mediastack.com/v1/")
                .client(httpClient)
                .addConverterFactory(kotlinxSerializationFactory)
                .build()
        }

        @Provides
        @Singleton
        @KotlinxSerializationFactory
        fun provideKotlinxSerializationFactory(): Converter.Factory {
            val contentType = "application/json".toMediaType()
            val json = Json {
                ignoreUnknownKeys = true
                isLenient = true
            }
            return json.asConverterFactory(contentType)
        }
    }

