package com.flat14.study.data

import com.flat14.study.domain.CityRepository

class TemporaryCityListRepository: CityRepository {

    private val cities = mutableListOf("Aveiro")

    override suspend fun getCityList(): List<String> {
        return cities
    }

    override suspend fun addCity(city: String) {
        cities.add(city)
    }

}