package com.example.weatherforecast.ui.customview

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.CustomViewFetchDataBinding
import com.example.weatherforecast.util.gone
import com.example.weatherforecast.util.visible

class CustomViewFetchData(ctx: Context, attrs: AttributeSet) : ConstraintLayout(ctx, attrs) {

    private var binding: CustomViewFetchDataBinding

    init {
        val view = inflate(ctx, R.layout.custom_view_fetch_data, this)
        binding = CustomViewFetchDataBinding.bind(view)
    }

    fun fetching() {
        binding.apply {
            lottie.playAnimation()
            lottie.visible()
            fetchMessage.visible()
            appName.visible()
            failureMessage.gone()
            failureNote.gone()
            tryAgain.gone()
        }
    }


}