package com.example.weatherforecast.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.data.model.HourlyWeatherForecast
import com.example.weatherforecast.databinding.ItemViewHourlyTempBinding

class HourlyTempListAdapter(
    private val fn: (hourlyWeatherForecast: HourlyWeatherForecast) -> Unit
) {

    inner class HourlyTempViewHolder(private val binding: ItemViewHourlyTempBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}