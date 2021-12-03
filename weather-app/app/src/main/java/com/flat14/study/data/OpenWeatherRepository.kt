package com.flat14.study.data

import com.flat14.study.domain.WeatherRepository
import com.flat14.study.domain.model.CityWeather
import io.reactivex.rxjava3.core.Single

class OpenWeatherRepository(private val weatherAPI: WeatherAPI) : WeatherRepository {

    override fun getCurrentWeather(city: String): Single<CityWeather> {
        return weatherAPI.getWeatherForCity(city).map {
            val weather = it.weather.first()
            CityWeather(
                name = it.name,
                weather = weather.main,
                description = weather.description,
                icon = weather.icon,
                temperature = it.temperature.temperature,
                feelsLike = it.temperature.feedsLike,
                min = it.temperature.min,
                max = it.temperature.max,
                humidity = it.temperature.humidity
            )
        }
    }

    override fun getWeatherForecast(city: String) {
        TODO("Not yet implemented")
    }

}