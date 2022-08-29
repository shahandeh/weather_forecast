package com.example.weatherforecast.data.model

data class HourlyWeatherForecast(
    val dewPoint: String,
    val directRadiation: String,
    val precipitation: String,
    val relativeHumidity: String,
    val pressure: String,
    val temperature: String,
    val time: String,
    val weatherCode: Int,
    val windSpeed: String
)
