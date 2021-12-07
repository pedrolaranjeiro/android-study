package com.flat14.study.domain

class GetWeatherUseCase(private val repository: WeatherRepository) {

    suspend fun getCurrentWeather(city: String) =
        repository.getCurrentWeather(city)

    suspend fun getWeatherForecast(city: String) =
        repository.getWeatherForecast(city)

}