package com.example.weatherforecast.util

import com.bumptech.glide.Glide
import com.example.weatherforecast.R
import com.google.android.material.imageview.ShapeableImageView

fun ShapeableImageView.getWeatherImage(weatherCode: Int, time: String = "AM") {
    val resId: Int = if (time.contains("PM")) when (weatherCode) {
        0 -> R.drawable.ic_clear_sky_night
        1 -> R.drawable.ic_mainly_clear_night
        2 -> R.drawable.ic_partly_cloudy_night
        3 -> R.drawable.ic_overcast
        45, 48 -> R.drawable.ic_foggy
        51 -> R.drawable.ic_light_drizzle_night
        53 -> R.drawable.ic_moderate_drizzle_night
        55 -> R.drawable.ic_dense_drizzle_night
        56, 66, 85 -> R.drawable.ic_light_freezing_drizzle_night
        57, 67 -> R.drawable.ic_dense_freezing_drizzle_night
        61 -> R.drawable.ic_slight_rain_night
        63 -> R.drawable.ic_moderate_rain_night
        65 -> R.drawable.ic_heavy_rain_night
        71 -> R.drawable.ic_slight_snow_fall_night
        73 -> R.drawable.ic_moderate_snow_fall_night
        75, 86 -> R.drawable.ic_heavy_snow_fall
        77 -> R.drawable.ic_snow_grains
        80 -> R.drawable.ic_slight_rain_shower_night
        81 -> R.drawable.ic_moderate_rain_shower_night
        82 -> R.drawable.ic_violent_rain_shower_night
        95, 99 -> R.drawable.ic_heavy_hail_thunder_storm_night
        96 -> R.drawable.ic_slight_hail_thunder_storm_night
        else -> R.drawable.ic_clear_sky_night
    }
    else when (weatherCode) {
        0 -> R.drawable.ic_clear_sky_day
        1 -> R.drawable.ic_mainly_clear_day
        2 -> R.drawable.ic_partly_cloudy_day
        3 -> R.drawable.ic_overcast
        45, 48 -> R.drawable.ic_foggy
        51 -> R.drawable.ic_light_drizzle_day
        53 -> R.drawable.ic_moderate_drizzle_day
        55 -> R.drawable.ic_dense_drizzle_day
        56, 66, 85 -> R.drawable.ic_light_freezing_drizzle_day
        57, 67 -> R.drawable.ic_dense_freezing_drizzle_day
        61 -> R.drawable.ic_slight_rain_day
        63 -> R.drawable.ic_moderate_rain_day
        65 -> R.drawable.ic_heavy_rain_day
        71 -> R.drawable.ic_slight_snow_fall_day
        73 -> R.drawable.ic_moderate_snow_fall_day
        75, 86 -> R.drawable.ic_heavy_snow_fall
        77 -> R.drawable.ic_snow_grains
        80 -> R.drawable.ic_slight_rain_shower_day
        81 -> R.drawable.ic_moderate_rain_shower_day
        82 -> R.drawable.ic_violent_rain_shower_day
        95, 99 -> R.drawable.ic_heavy_hail_thunder_storm_day
        96 -> R.drawable.ic_slight_hail_thunder_storm_day
        else -> R.drawable.ic_clear_sky_day
    }

    Glide.with(this)
        .load(resId)
        .into(this)
}