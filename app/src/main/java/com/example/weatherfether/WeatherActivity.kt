package com.example.weatherfether

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.UUID

class WeatherActivity : AppCompatActivity() {
    private val weatherPresent = WeatherPresent()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        val tvTempreture = findViewById<TextView>(R.id.tvTempreture)
        tvTempreture.text = weatherPresent.getWeather(UUID.randomUUID().toString())
    }
}