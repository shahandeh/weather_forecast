package com.example.weatherforecast.ui.customview

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.CustomViewDailyDetailBinding
import com.example.weatherforecast.util.getWeatherImage
import com.example.weatherforecast.util.gone
import com.example.weatherforecast.util.visible

class CustomViewDailyDetail(ctx: Context, attrs: AttributeSet) : ConstraintLayout(ctx, attrs) {

    private var binding: CustomViewDailyDetailBinding
    private var dayList: RecyclerView
    private var dayTempList: RecyclerView

    init {
        val view = inflate(ctx, R.layout.custom_view_daily_detail, this)
        binding = CustomViewDailyDetailBinding.bind(view)
        dayList = binding.dayList
        dayTempList = binding.dailyTempList
    }

    fun temp(input: String) {
        binding.temp.text = input
    }

    fun weatherImage(weatherCode: Int) {
        binding.weatherImage.getWeatherImage(weatherCode)
    }

    fun precipitation(input: String) {
        binding.precipitationAmount.text = input
    }

    fun wind(input: String) {
        binding.windAmount.text = input
    }

    fun uvIndex(input: String) {
        binding.uvIndexAmount.text = input
    }

    fun sunrise(input: String) {
        binding.sunriseAmount.text = input
    }

    fun sunset(input: String) {
        binding.sunsetAmount.text = input
    }

    private fun hideDetail() {
        binding.detailLayout.gone()
        binding.dailyTempList.visible()
    }

}