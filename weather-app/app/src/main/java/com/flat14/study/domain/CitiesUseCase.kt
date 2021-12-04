package com.flat14.study.domain

class CitiesUseCase (private val cityRepository: CityRepository) {

    fun getListOfCities() = cityRepository.getCityList()

    fun addCity(city: String){
        cityRepository.addCity(city)
    }

}