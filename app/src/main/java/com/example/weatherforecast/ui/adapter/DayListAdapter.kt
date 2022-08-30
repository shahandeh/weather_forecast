package com.example.weatherforecast.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.data.model.DailyWeatherForecast
import com.example.weatherforecast.databinding.ItemViewDailyDetailDayViewBinding

class DayListAdapter(
    private val fn: (date: String) -> Unit
) {

    inner class DayViewHolder(private val binding: ItemViewDailyDetailDayViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dailyWeatherForecast: DailyWeatherForecast) {
            val date = dailyWeatherForecast.date.split("-")
            binding.apply {
                day.text = date[2]
                month.text = date[1]
                year.text = date[0]
            }
            binding.root.setOnClickListener {
                fn(dailyWeatherForecast.date)
            }
        }

    }
}