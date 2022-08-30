package com.example.weatherforecast.ui.customview

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherforecast.databinding.CustomViewDailyDetailBinding

class CustomViewDailyDetail(ctx: Context, attrs: AttributeSet) : ConstraintLayout(ctx, attrs) {

    private var binding: CustomViewDailyDetailBinding
    private var dayList: RecyclerView

}