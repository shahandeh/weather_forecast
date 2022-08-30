package com.example.weatherforecast.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.databinding.ItemViewDailyTempBinding

class DailyTempListAdapter(
    private val fn: (time: String) -> Unit
) {

    inner class DailyTempViewHolder(private val binding: ItemViewDailyTempBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

}