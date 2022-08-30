package com.example.weatherforecast.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.data.Repository
import com.example.weatherforecast.data.model.HourlyWeatherForecast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {



    private var _currentHourForecast: MutableStateFlow<HourlyWeatherForecast?> =
        MutableStateFlow(null)
    val currentHourForecast: StateFlow<HourlyWeatherForecast?> = _currentHourForecast
    private fun getCurrentHourForecast() {
        viewModelScope.launch {
            repository.currentHourForecast().collect {
                _currentHourForecast.emit(it)
            }
        }
    }

}