package com.example.weatherforecast.di

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
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

}