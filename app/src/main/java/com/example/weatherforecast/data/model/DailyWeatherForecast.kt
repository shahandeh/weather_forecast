package com.example.weatherforecast.data.model

data class DailyWeatherForecast(
    val precipitation: String,
    val shortwaveRadiation: String,
    val sunrise: String,
    val sunset: String,
    val temperature: String,
    val date: String,
    val weatherCode: Int,
    val windSpeed: String
)