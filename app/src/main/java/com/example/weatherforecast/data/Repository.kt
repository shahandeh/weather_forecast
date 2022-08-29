package com.example.weatherforecast.data

import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val locationDataSource: ILocationDataSource
) {
}