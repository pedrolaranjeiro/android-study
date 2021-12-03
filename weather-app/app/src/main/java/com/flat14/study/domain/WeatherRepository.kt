package com.flat14.study.domain

import com.flat14.study.domain.model.CityWeather
import io.reactivex.rxjava3.core.Single

interface WeatherRepository {
    fun getCurrentWeather(city: String): Single<CityWeather>
    fun getWeatherForecast(city: String)
}