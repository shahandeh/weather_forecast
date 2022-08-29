package com.example.weatherforecast.data

import android.location.Location

interface ILocationDataSource {

    suspend fun getCurrentLocation(): Location?

}