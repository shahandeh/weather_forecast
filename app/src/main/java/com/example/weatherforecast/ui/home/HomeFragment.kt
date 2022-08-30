package com.example.weatherforecast.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.weatherforecast.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_home) {

    private val homeViewModel by viewModels<HomeViewModel>()

}