package com.example.weatherforecast.ui.home

import androidx.lifecycle.ViewModel
import com.example.weatherforecast.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {
}