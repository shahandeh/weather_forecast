package com.example.weatherforecast.data

import android.location.Location
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val locationDataSource: ILocationDataSource
) {

    suspend fun getCurrentLocation(): Location? = locationDataSource.getCurrentLocation()

}