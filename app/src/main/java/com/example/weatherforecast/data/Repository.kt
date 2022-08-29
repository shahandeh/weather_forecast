package com.example.weatherforecast.data

import android.location.Location
import com.example.weatherforecast.data.model.DailyWeatherForecast
import com.example.weatherforecast.data.model.HourlyWeatherForecast
import com.example.weatherforecast.util.ApiResponse
import com.example.weatherforecast.util.currentHour
import com.example.weatherforecast.util.dailyResponseAdapter
import com.example.weatherforecast.util.hourlyResponseAdapter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val locationDataSource: ILocationDataSource
) {

    private lateinit var hourlyForecastCache: List<HourlyWeatherForecast>
    private lateinit var dailyForecastCache: List<DailyWeatherForecast>

    suspend fun getCurrentLocation(): Location? = locationDataSource.getCurrentLocation()

    suspend fun getForecast(
        location: Location
    ) = flow {
        emit(ApiResponse.Loading)
        try {
            if (::hourlyForecastCache.isInitialized) {
                emit(ApiResponse.Success)
            } else {
                val response = remoteDataSource.getForecast(location.latitude, location.longitude)
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    hourlyForecastCache = body.hourlyResponseAdapter()
                    dailyForecastCache = body.dailyResponseAdapter()
                    emit(ApiResponse.Success)
                }
            }
        } catch (e: Exception) {
            emit(ApiResponse.Failure(e.message))
        }

    }

    fun currentHourForecast(): Flow<HourlyWeatherForecast> =
        flowOf(hourlyForecastCache[currentHour().toInt()])

    fun currentDayHourlyForecast(): Flow<List<HourlyWeatherForecast>> =
        flowOf(hourlyForecastCache.subList(0, 24))

    fun weekForecast(): Flow<List<DailyWeatherForecast>> =
        flowOf(dailyForecastCache)

}