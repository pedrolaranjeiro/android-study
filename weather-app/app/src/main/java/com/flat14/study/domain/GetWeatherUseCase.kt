package com.flat14.study.domain

class GetWeatherUseCase(private val repository: WeatherRepository) {

    fun getCurrentWeather(city: String) =
        repository.getCurrentWeather(city)


    fun getWeatherForecast(city: String) {
        repository.getWeatherForecast(city)
    }

}