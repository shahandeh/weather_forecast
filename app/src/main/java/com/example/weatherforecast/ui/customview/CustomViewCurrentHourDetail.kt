package com.example.weatherforecast.ui.customview

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.CustomViewCurrentHourTempBinding
import com.example.weatherforecast.util.getWeatherImage

class CustomViewCurrentHourDetail(ctx: Context, attrs: AttributeSet) :
    ConstraintLayout(ctx, attrs) {

    private var binding: CustomViewCurrentHourTempBinding

    init {
        val view = inflate(ctx, R.layout.custom_view_current_hour_temp, this)
        binding = CustomViewCurrentHourTempBinding.bind(view)
    }

    fun setImage(weatherCode: Int, time: String) {
        binding.image.getWeatherImage(weatherCode, time)
    }

    fun setTemp(input: String) {
        binding.temp.text = input
    }

    fun setWind(input: String) {
        binding.wind.text = input
    }

    fun setPressure(input: String) {
        binding.pressure.text = input
    }

    fun setHumidity(input: String) {
        binding.humidity.text = input
    }

    fun setPrecipitation(input: String) {
        binding.precipitation.text = input
    }

}