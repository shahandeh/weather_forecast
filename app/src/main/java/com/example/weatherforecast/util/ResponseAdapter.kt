package com.example.weatherforecast.util

import com.example.weatherforecast.data.model.DailyWeatherForecast
import com.example.weatherforecast.data.model.ForecastApiResponse
import com.example.weatherforecast.data.model.HourlyWeatherForecast

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

fun ForecastApiResponse.hourlyResponseAdapter(): List<HourlyWeatherForecast> {
    val hourlyForecastList = this.hourly
    val hourlyUnit = this.hourlyUnits
    val hourlyWeatherForecast = mutableListOf<HourlyWeatherForecast>()
    for (i in hourlyForecastList.time.indices){
        hourlyWeatherForecast.add(
            HourlyWeatherForecast(
                dewPoint = hourlyForecastList.dewPoint[i].toString() + hourlyUnit.dewPoint,
                directRadiation = hourlyForecastList.radiation[i].toString() + hourlyUnit.radiation,
                precipitation = hourlyForecastList.precipitation[i].toString() + hourlyUnit.precipitation,
                relativeHumidity = hourlyForecastList.relativeHumidity[i].toString() + hourlyUnit.relativeHumidity,
                pressure = hourlyForecastList.pressure[i].toString() + hourlyUnit.pressure,
                temperature = hourlyForecastList.temperature[i].toString() + hourlyUnit.temperature,
                time = hourlyForecastList.time[i],
                weatherCode = hourlyForecastList.weatherCode[i],
                windSpeed = hourlyForecastList.windSpeed[i].toString() + hourlyUnit.windSpeed
            )
        )
    }
    return hourlyWeatherForecast
}