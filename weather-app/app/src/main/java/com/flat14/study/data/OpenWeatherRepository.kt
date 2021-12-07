package com.flat14.study.data

import com.flat14.study.data.model.OpenCityWeather
import com.flat14.study.data.model.OpenForecast
import com.flat14.study.domain.WeatherRepository
import com.flat14.study.domain.model.CityWeather
import com.flat14.study.domain.model.CityWeatherForecast
import com.flat14.study.domain.model.Forecast
import io.reactivex.rxjava3.core.Single
import java.text.SimpleDateFormat
import java.util.*

class OpenWeatherRepository(private val weatherAPI: WeatherAPI) : WeatherRepository {

    override fun getCurrentWeather(city: String): Single<CityWeather> {
        return weatherAPI.getWeatherForCity(city).map {
            mapToCityWeather(it)
        }
    }

    override fun getWeatherForecast(city: String): Single<CityWeatherForecast> {
        return weatherAPI.getWeatherForecastForCity(city)
            .map { openCityWeatherForecast ->

                val forecastList = mutableListOf<Forecast>()

                openCityWeatherForecast.forecast.forEach { forecast ->
                    forecastList.add(
                        mapToForecast(forecast)
                    )
                }

                CityWeatherForecast(
                    name = openCityWeatherForecast.city.name,
                    forecast = forecastList
                )
            }
    }

    private fun mapToCityWeather(
        dataModel: OpenCityWeather
    ): CityWeather {
        val weather = dataModel.weather.first()
        return CityWeather(
            name = dataModel.name,
            weather = weather.main,
            description = weather.description,
            icon = weather.icon,
            temperature = dataModel.temperature.temperature,
            feelsLike = dataModel.temperature.feedsLike,
            min = dataModel.temperature.min,
            max = dataModel.temperature.max,
            humidity = dataModel.temperature.humidity
        )
    }

    private fun mapToForecast(
        dataModel: OpenForecast,
    ): Forecast {
        val weather = dataModel.weather.first()
        return Forecast(
            date = day(dataModel.date),
            weather = weather.main,
            description = weather.description,
            icon = weather.icon,
            temperature = dataModel.temperature.temperature,
            feelsLike = dataModel.temperature.feedsLike,
            min = dataModel.temperature.min,
            max = dataModel.temperature.max,
            humidity = dataModel.temperature.humidity
        )
    }


    private fun day(dateString: String): String {
        val date: Date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString)
        return SimpleDateFormat("E").format(date)
    }

}

