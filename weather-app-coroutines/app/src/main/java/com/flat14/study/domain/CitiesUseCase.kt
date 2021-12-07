package com.flat14.study.domain

class CitiesUseCase (private val cityRepository: CityRepository) {

    suspend fun getListOfCities() = cityRepository.getCityList()

    suspend fun addCity(city: String){
        cityRepository.addCity(city)
    }

}