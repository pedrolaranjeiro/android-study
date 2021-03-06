package com.flat14.study.data.model

import com.google.gson.annotations.SerializedName

data class OpenCityWeather(
    val name: String,
    val weather: List<OpenWeather>,
    @SerializedName("main")
    val temperature: OpenTemperature
)

data class OpenWeather(
    val id: String,
    val main: String,
    val description: String,
    val icon: String
)

data class OpenTemperature(
    @SerializedName("temp")
    val temperature: Double,
    @SerializedName("feels_like")
    val feedsLike: Double,
    @SerializedName("temp_min")
    val min: Double,
    @SerializedName("temp_max")
    val max: Double,
    val humidity: Double
)