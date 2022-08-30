package com.example.weatherforecast.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherforecast.R
import com.example.weatherforecast.databinding.FragmentHomeBinding
import com.example.weatherforecast.ui.adapter.DailyTempListAdapter
import com.example.weatherforecast.ui.adapter.DayListAdapter
import com.example.weatherforecast.ui.adapter.HourlyTempListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_home) {

    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var hourlyTempListAdapter: HourlyTempListAdapter
    private lateinit var dailyTempListAdapter: DailyTempListAdapter
    private lateinit var dayListAdapter: DayListAdapter

}