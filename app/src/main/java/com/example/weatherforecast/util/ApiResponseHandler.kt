package com.example.weatherforecast.util

fun <T>ApiResponse<T>.apiResponseHandler(loading: () -> Unit, success: () -> Unit, failure: (message: String?) -> Unit){
    when (this) {
        ApiResponse.Loading -> loading()
        ApiResponse.Success -> success()
        is ApiResponse.Failure -> failure(this.message)
    }
}