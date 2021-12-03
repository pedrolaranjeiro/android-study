package com.flat14.study.domain

class GetCitiesUseCase (private val cityRepository: CityRepository) {

    fun getListOfCities() = cityRepository.getCityList()

}