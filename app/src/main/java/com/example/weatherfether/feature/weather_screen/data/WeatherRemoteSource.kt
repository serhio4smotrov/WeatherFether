package com.example.weatherfether.feature.weather_screen.data

import com.example.weatherfether.feature.weather_screen.data.model.WeatherRemoteModel
import retrofit2.Response

class WeatherRemoteSource (private val api: WeatherApi) {
    //todo add query
   suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(query = "Moscow")
    }
}