package com.example.weatherforecast.util

sealed class ApiResponse<T>{
    object Loading : ApiResponse<Nothing>()
    object Success : ApiResponse<Nothing>()
    data class Failure<T>(val message: String?) : ApiResponse<T>()
}
