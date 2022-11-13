package com.example.weatherfether

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.weatherfether.feature.weather_screen.WeatherInteractor
import com.example.weatherfether.feature.weather_screen.data.WeatherApiClient
import com.example.weatherfether.feature.weather_screen.data.WeatherRemoteSource
import com.example.weatherfether.feature.weather_screen.data.WeatherRepo
import com.example.weatherfether.feature.weather_screen.data.WeatherRepoImpl
import com.example.weatherfether.feature.weather_screen.ui.WeatherScreenPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var presenter: WeatherScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = WeatherScreenPresenter(
            WeatherInteractor(
                WeatherRepoImpl(
                    WeatherRemoteSource(
                        WeatherApiClient.getApi())
                )
            )
        )
        val textViewHello = findViewById<TextView>(R.id.tvHello)
        var weather = ""
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                textViewHello.text = presenter.getWeather()
            }
        }
    }
}