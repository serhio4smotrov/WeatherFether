package com.example.weatherfether.feature.weather_screen.data

interface WeatherRepo {
    suspend fun getTemperature(): String
}