package com.example.weatherforecast.data.remote.service

import com.example.weatherforecast.data.model.ForecastApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("forecast?hourly=temperature_2m,relativehumidity_2m,dewpoint_2m,surface_pressure,precipitation,weathercode,direct_radiation,windspeed_10m&daily=weathercode,temperature_2m_max,temperature_2m_min,sunrise,sunset,precipitation_sum,windspeed_10m_max,shortwave_radiation_sum")
    suspend fun getForecast(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("timezone") timezone: String = "auto",
    ): Response<ForecastApiResponse>

}