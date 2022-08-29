package com.example.weatherforecast.data

import android.location.Location
import com.example.weatherforecast.data.model.HourlyWeatherForecast
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val locationDataSource: ILocationDataSource
) {

    private lateinit var hourlyForecastCache: List<HourlyWeatherForecast>

    suspend fun getCurrentLocation(): Location? = locationDataSource.getCurrentLocation()

}