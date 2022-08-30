package com.example.weatherforecast.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.data.model.HourlyWeatherForecast
import com.example.weatherforecast.databinding.ItemViewHourlyTempBinding
import com.example.weatherforecast.util.getWeatherImage
import com.example.weatherforecast.util.timeAdapter

class HourlyTempListAdapter(
    private val fn: (hourlyWeatherForecast: HourlyWeatherForecast) -> Unit
) : ListAdapter<HourlyWeatherForecast, HourlyTempListAdapter.HourlyTempViewHolder>(
        HourlyTempDiffCallback()
    ) {

    inner class HourlyTempViewHolder(private val binding: ItemViewHourlyTempBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hourlyWeatherForecast: HourlyWeatherForecast) {
            binding.hour.text = hourlyWeatherForecast.time.timeAdapter()
            binding.temp.text = hourlyWeatherForecast.temperature
            binding.image.getWeatherImage(
                hourlyWeatherForecast.weatherCode,
                hourlyWeatherForecast.time.timeAdapter()
            )
            binding.root.setOnClickListener { fn(hourlyWeatherForecast) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyTempViewHolder =
        HourlyTempViewHolder(
            ItemViewHourlyTempBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: HourlyTempViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class HourlyTempDiffCallback : DiffUtil.ItemCallback<HourlyWeatherForecast>() {

    override fun areItemsTheSame(oldItem: HourlyWeatherForecast, newItem: HourlyWeatherForecast) =
        oldItem == newItem

    override fun areContentsTheSame(
        oldItem: HourlyWeatherForecast,
        newItem: HourlyWeatherForecast
    ) = oldItem == newItem

}