package com.flat14.study.domain.model

data class CityWeather(
    val name: String,
    val weather: String,
    val description: String,
    val icon: String,
    val temperature: Double,
    val feelsLike: Double,
    val min: Double,
    val max: Double,
    val humidity: Double
)

fun getIconUrl(icon: String) = "https://openweathermap.org/img/wn/$icon@2x.png"


