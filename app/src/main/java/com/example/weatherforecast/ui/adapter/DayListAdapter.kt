package com.example.weatherforecast.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.data.model.DailyWeatherForecast
import com.example.weatherforecast.databinding.ItemViewDailyDetailDayViewBinding

class DayListAdapter(
    private val fn: (date: String) -> Unit
) :
    ListAdapter<DailyWeatherForecast, DayListAdapter.DayViewHolder>(DayDiffCallback()) {

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

class DayDiffCallback : DiffUtil.ItemCallback<DailyWeatherForecast>() {

    override fun areItemsTheSame(oldItem: DailyWeatherForecast, newItem: DailyWeatherForecast) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: DailyWeatherForecast, newItem: DailyWeatherForecast) =
        oldItem == newItem

}