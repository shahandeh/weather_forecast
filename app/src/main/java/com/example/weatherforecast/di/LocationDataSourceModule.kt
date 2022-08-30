package com.example.weatherforecast.di

import android.app.Application
import android.content.Context
import com.example.weatherforecast.data.ILocationDataSource
import com.example.weatherforecast.data.location.LocationDataSource
import com.google.android.gms.location.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationDataSourceModule {

    @Singleton
    @Provides
    fun provideGetFusedLocation(
        @ApplicationContext context: Context
    ): FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    @Singleton
    @Provides
    fun provideFusedLocationRequest(): LocationRequest = LocationRequest.create().apply{
        interval = 1000
        fastestInterval = 5000
        priority = Priority.PRIORITY_HIGH_ACCURACY
    }

    @Singleton
    @Provides
    fun provideFusedLocationCallback(): LocationCallback = object : LocationCallback() {}

    @Singleton
    @Provides
    fun provideLocationDataSource(
        fusedLocationProviderClient: FusedLocationProviderClient,
        locationRequest: LocationRequest,
        locationCallback: LocationCallback,
        application: Application
    ): ILocationDataSource = LocationDataSource(
        fusedLocationProviderClient, locationRequest,
        locationCallback, application
    )

}