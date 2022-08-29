package com.example.weatherforecast.data.remote

import com.example.weatherforecast.data.IRemoteDataSource
import com.example.weatherforecast.data.model.ForecastApiResponse
import com.example.weatherforecast.data.remote.service.ApiService
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
): IRemoteDataSource {
    override suspend fun getForecast(
        latitude: Double,
        longitude: Double
    ): Response<ForecastApiResponse> {
        TODO("Not yet implemented")
    }

}