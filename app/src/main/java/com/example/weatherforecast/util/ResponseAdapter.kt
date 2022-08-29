package com.example.weatherforecast.util

import com.example.weatherforecast.data.model.DailyWeatherForecast
import com.example.weatherforecast.data.model.ForecastApiResponse

fun ForecastApiResponse.dailyResponseAdapter(): List<DailyWeatherForecast> {
    val dailyForecastList = this.daily
    val dailyUnit = this.dailyUnits
    val dailyWeatherForecast = mutableListOf<DailyWeatherForecast>()
    for (i in dailyForecastList.time.indices){
        dailyWeatherForecast.add(
            DailyWeatherForecast(
                precipitation = dailyForecastList.precipitation[i].toString() + dailyUnit.precipitation,
                shortwaveRadiation = dailyForecastList.shortwaveRadiation[i].toString() + dailyUnit.shortwaveRadiation,
                sunrise = dailyForecastList.sunrise[i].split("T")[1],
                sunset = dailyForecastList.sunset[i].split("T")[1],
                temperature = dailyForecastList.temperatureMin[i].toString() + "/" + dailyForecastList.temperatureMax[i] + dailyUnit.temperatureMin,
                date = dailyForecastList.time[i],
                weatherCode = dailyForecastList.weatherCode[i],
                windSpeed = dailyForecastList.windSpeedMax[i].toString() + dailyUnit.windSpeedMax
            )
        )
    }
    return dailyWeatherForecast
}