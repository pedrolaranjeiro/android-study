package com.flat14.study.data.model

import com.google.gson.annotations.SerializedName

data class OpenCityWeatherForecast(
    val city: OpenCity,
    @SerializedName("list")
    val forecast : List<OpenForecast>
)

data class OpenForecast(
    @SerializedName("dt_txt")
    val date: String,
    @SerializedName("main")
    val temperature: OpenTemperature,
    val weather: List<OpenWeather>
)

data class OpenCity(
    val name: String
)