package com.example.weatherforecast.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.data.model.DailyWeatherForecast
import com.example.weatherforecast.databinding.ItemViewDailyTempBinding
import com.example.weatherforecast.util.getWeatherImage

class DailyTempListAdapter(
    private val fn: (time: String) -> Unit
) {

    inner class DailyTempViewHolder(private val binding: ItemViewDailyTempBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dailyWeatherForecast: DailyWeatherForecast) {
            binding.date.text = dailyWeatherForecast.date.split("T")[0]
            binding.temp.text = dailyWeatherForecast.temperature
            binding.image.getWeatherImage(dailyWeatherForecast.weatherCode)
            binding.root.setOnClickListener {
                fn(dailyWeatherForecast.date)
            }
        }

    }

}

class DailyTempDiffCallback : DiffUtil.ItemCallback<DailyWeatherForecast>() {

    override fun areItemsTheSame(oldItem: DailyWeatherForecast, newItem: DailyWeatherForecast) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: DailyWeatherForecast, newItem: DailyWeatherForecast) =
        oldItem == newItem

}