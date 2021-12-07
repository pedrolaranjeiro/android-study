package com.flat14.study.domain

import com.flat14.study.domain.model.CityWeather
import com.flat14.study.domain.model.CityWeatherForecast

interface WeatherRepository {

    suspend fun getCurrentWeather(city: String): CityWeather

    suspend fun getWeatherForecast(city: String): CityWeatherForecast

}