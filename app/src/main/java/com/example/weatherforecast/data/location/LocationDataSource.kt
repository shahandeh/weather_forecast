package com.example.weatherforecast.data.location

import android.app.Application
import com.example.weatherforecast.data.ILocationDataSource
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import javax.inject.Inject

class LocationDataSource @Inject constructor(
    private val fusedLocationProviderClient: FusedLocationProviderClient,
    private val locationRequest: LocationRequest,
    private val locationCallback: LocationCallback,
    private val application: Application
) {
}