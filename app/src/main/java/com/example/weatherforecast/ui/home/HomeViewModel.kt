package com.example.weatherforecast.ui.home

import android.location.Location
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.data.Repository
import com.example.weatherforecast.data.model.DailyWeatherForecast
import com.example.weatherforecast.data.model.HourlyWeatherForecast
import com.example.weatherforecast.util.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    init {
        getCurrentLocation()
    }

    fun getCurrentLocation() {
        viewModelScope.launch {
            val location = repository.getCurrentLocation()
            if (location != null) fetchDataFromApi(location)
        }
    }

    private var _apiResponse: MutableStateFlow<ApiResponse<out String>> =
        MutableStateFlow(ApiResponse.Loading)
    val apiResponse: StateFlow<ApiResponse<out String>> = _apiResponse
    private fun fetchDataFromApi(location: Location) {
        viewModelScope.launch {
            repository.getForecast(location).collect {
                if (it == ApiResponse.Success) getData()
                _apiResponse.emit(it)
            }
        }
    }

    private fun getData() {
        getCurrentHourForecast()
        getCurrentDayHourlyForecast()
        getWeekForecast()
    }

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

    private var _currentDayHourlyForecast: MutableStateFlow<List<HourlyWeatherForecast>> =
        MutableStateFlow(emptyList())
    val currentDayHourlyForecast: StateFlow<List<HourlyWeatherForecast>> = _currentDayHourlyForecast
    private fun getCurrentDayHourlyForecast(){
        viewModelScope.launch {
            repository.currentDayHourlyForecast().collect {
                _currentDayHourlyForecast.emit(it)
            }
        }
    }

    private var _weekForecast: MutableStateFlow<List<DailyWeatherForecast>> =
        MutableStateFlow(emptyList())
    val weekForecast: StateFlow<List<DailyWeatherForecast>> = _weekForecast
    private fun getWeekForecast(){
        viewModelScope.launch {
            repository.weekForecast().collect{
                _weekForecast.emit(it)
            }
        }
    }

    private var _dayForecast: MutableSharedFlow<DailyWeatherForecast> = MutableSharedFlow()
    val dayForecast: SharedFlow<DailyWeatherForecast> = _dayForecast
    fun getDayForecast(date: String){
        viewModelScope.launch {
            repository.dayForecast(date).collect{
                _dayForecast.emit(it)
            }
        }
    }

}