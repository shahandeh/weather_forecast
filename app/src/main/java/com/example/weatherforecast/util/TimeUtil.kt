package com.example.weatherforecast.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun currentTime(): String {
    val calendar = Calendar.getInstance()
    val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
    return simpleDateFormat.format(calendar.time).toString().replace(" ", "T")
}