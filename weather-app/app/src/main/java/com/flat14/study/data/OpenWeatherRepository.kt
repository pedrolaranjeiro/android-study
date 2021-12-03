package com.flat14.study.data

import com.flat14.study.domain.WeatherRepository
import com.flat14.study.domain.model.CityWeather
import io.reactivex.rxjava3.core.Single

class OpenWeatherRepository(private val weatherAPI: WeatherAPI) : WeatherRepository {

    override fun getCurrentWeather(city: String): Single<CityWeather> {
//        return weatherAPI.getWeatherForCity(city).map {
//            CityWeather(
//                name = it.name,
//                weather = it.weather.main,
//                description = it.weather.description,
//                icon = it.weather.icon,
//                temperature = it.temperature.temperature,
//                feelsLike = it.temperature.feedsLike,
//                min = it.temperature.min,
//                max = it.temperature.max,
//                humidity = it.temperature.humidity
//            )
//        }
        return Single.just(
            CityWeather(
                name = "Aveiro",
                weather = "Rain",
                description = "Meh",
                icon = "as",
                temperature = 3.0,
                feelsLike = 11.0,
                min = 5.0,
                max = 20.1,
                humidity = 77.0
            )
        )
    }

    override fun getWeatherForecast(city: String) {
        TODO("Not yet implemented")
    }

}