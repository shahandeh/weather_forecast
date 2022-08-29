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

fun String.timeAdapter(): String {
    val date = this.split("T")[0]
    val hour = this.split("T")[1].split(":")[0]

    return if (hour == "00") date
    else if (hour.toInt() > 12) "${hour.toInt() - 12}PM"
    else "${hour.toInt()}AM"
}