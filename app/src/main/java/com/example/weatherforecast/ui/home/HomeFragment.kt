package com.example.weatherforecast.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherforecast.R
import com.example.weatherforecast.data.model.DailyWeatherForecast
import com.example.weatherforecast.data.model.HourlyWeatherForecast
import com.example.weatherforecast.databinding.FragmentHomeBinding
import com.example.weatherforecast.ui.adapter.DailyTempListAdapter
import com.example.weatherforecast.ui.adapter.DayListAdapter
import com.example.weatherforecast.ui.adapter.HourlyTempListAdapter
import com.example.weatherforecast.util.timeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_home) {

    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var hourlyTempListAdapter: HourlyTempListAdapter
    private lateinit var dailyTempListAdapter: DailyTempListAdapter
    private lateinit var dayListAdapter: DayListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun setCurrentHourDetail(it: HourlyWeatherForecast) {
        binding.currentHourDetail.apply {
            setTemp(it.temperature)
            setImage(it.weatherCode, it.time.timeAdapter())
            setWind(it.windSpeed)
            setHumidity(it.relativeHumidity)
            setUvIndex(it.directRadiation)
            setPressure(it.pressure)
            setPrecipitation(it.precipitation)
            setDewPoint(it.dewPoint)
        }
    }

    private fun dailyDetailInit(dailyWeatherForecastList: List<DailyWeatherForecast>) {
        binding.dailyDetail.dayListRecyclerView().adapter = dayListAdapter
        dayListAdapter.submitList(dailyWeatherForecastList)

        binding.dailyDetail.dayTempListRecyclerView().adapter = dailyTempListAdapter
        dailyTempListAdapter.submitList(dailyWeatherForecastList)
    }

    private fun showDailyDetail(dailyWeatherForecast: DailyWeatherForecast) {
        binding.dailyDetail.apply {
            showDetail()
            temp(dailyWeatherForecast.temperature)
            weatherImage(dailyWeatherForecast.weatherCode)
            precipitation(dailyWeatherForecast.precipitation)
            wind(dailyWeatherForecast.windSpeed)
            uvIndex(dailyWeatherForecast.shortwaveRadiation)
            sunrise(dailyWeatherForecast.sunrise)
            sunset(dailyWeatherForecast.sunset)
        }
    }

    private fun getDayForecast(date: String) {
        homeViewModel.getDayForecast(date)
    }

}