package com.example.weatherforecast.util

sealed class ApiResponse<T>{
    object Loading : ApiResponse<Nothing>()
    object Success : ApiResponse<Nothing>()
}
