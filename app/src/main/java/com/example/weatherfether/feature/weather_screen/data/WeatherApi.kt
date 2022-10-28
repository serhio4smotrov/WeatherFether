package com.example.weatherfether.feature.weather_screen.data

import com.example.weatherfether.API_KEY
import com.example.weatherfether.feature.weather_screen.data.model.WeatherRemoteModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
   suspend fun getWeather(
        @Query("q") query: String,
        @Query("appid") apiKey: String = API_KEY
    ): WeatherRemoteModel
}