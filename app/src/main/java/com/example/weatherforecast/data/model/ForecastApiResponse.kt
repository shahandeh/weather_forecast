package com.example.weatherforecast.data.model

import com.google.gson.annotations.SerializedName

data class Daily(
    @SerializedName("precipitation_sum")
    val precipitation: List<Double>,
    @SerializedName("shortwave_radiation_sum")
    val shortwaveRadiation: List<Double>,
    val sunrise: List<String>,
    val sunset: List<String>,
    @SerializedName("temperature_2m_max")
    val temperatureMax: List<Double>,
    @SerializedName("temperature_2m_min")
    val temperatureMin: List<Double>,
    val time: List<String>,
    @SerializedName("weathercode")
    val weatherCode: List<Int>,
    @SerializedName("windspeed_10m_max")
    val windSpeedMax: List<Double>
)

data class DailyUnits(
    @SerializedName("precipitation_sum")
    val precipitation: String,
    @SerializedName("shortwave_radiation_sum")
    val shortwaveRadiation: String,
    val sunrise: String,
    val sunset: String,
    @SerializedName("temperature_2m_max")
    val temperatureMax: String,
    @SerializedName("temperature_2m_min")
    val temperatureMin: String,
    val time: String,
    @SerializedName("weathercode")
    val weatherCode: String,
    @SerializedName("windspeed_10m_max")
    val windSpeedMax: String
)

data class Hourly(
    @SerializedName("dewpoint_2m")
    val dewPoint: List<Double>,
    @SerializedName("direct_radiation")
    val radiation: List<Int>,
    val precipitation: List<Double>,
    @SerializedName("relativehumidity_2m")
    val relativeHumidity: List<Int>,
    @SerializedName("surface_pressure")
    val pressure: List<Double>,
    @SerializedName("temperature_2m")
    val temperature: List<Double>,
    val time: List<String>,
    @SerializedName("weathercode")
    val weatherCode: List<Int>,
    @SerializedName("windspeed_10m")
    val windSpeed: List<Double>
)

data class HourlyUnits(
    @SerializedName("dewpoint_2m")
    val dewPoint: String,
    @SerializedName("direct_radiation")
    val radiation: String,
    val precipitation: String,
    @SerializedName("relativehumidity_2m")
    val relativeHumidity: String,
    @SerializedName("surface_pressure")
    val pressure: String,
    @SerializedName("temperature_2m")
    val temperature: String,
    val time: String,
    @SerializedName("weathercode")
    val weatherCode: String,
    @SerializedName("windspeed_10m")
    val windSpeed: String
)

data class ForecastApiResponse(
    val daily: Daily,
    @SerializedName("daily_units")
    val dailyUnits: DailyUnits,
    val hourly: Hourly,
    @SerializedName("hourly_units")
    val hourlyUnits: HourlyUnits
)