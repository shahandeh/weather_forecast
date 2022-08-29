package com.example.weatherforecast.data.remote

import com.example.weatherforecast.data.remote.service.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
){
}