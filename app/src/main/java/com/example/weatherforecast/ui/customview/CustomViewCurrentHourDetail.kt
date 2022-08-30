package com.example.weatherforecast.ui.customview

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.CustomViewCurrentHourTempBinding

class CustomViewCurrentHourDetail(ctx: Context, attrs: AttributeSet) :
    ConstraintLayout(ctx, attrs) {

    private var binding: CustomViewCurrentHourTempBinding

    init {
        val view = inflate(ctx, R.layout.custom_view_current_hour_temp, this)
        binding = CustomViewCurrentHourTempBinding.bind(view)
    }

}