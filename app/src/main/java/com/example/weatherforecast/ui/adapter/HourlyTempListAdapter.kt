package com.example.weatherforecast.ui.adapter

import com.example.weatherforecast.data.model.HourlyWeatherForecast

class HourlyTempListAdapter(
    private val fn: (hourlyWeatherForecast: HourlyWeatherForecast) -> Unit
) {
}