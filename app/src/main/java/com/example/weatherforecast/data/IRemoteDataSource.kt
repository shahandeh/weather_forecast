package com.example.weatherforecast.data

import com.example.weatherforecast.data.model.ForecastApiResponse
import retrofit2.Response

interface IRemoteDataSource {

    suspend fun getForecast(
        latitude: Double,
        longitude: Double
    ): Response<ForecastApiResponse>

}