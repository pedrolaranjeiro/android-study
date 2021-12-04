package com.flat14.study.data

import com.flat14.study.domain.CityRepository
import io.reactivex.rxjava3.core.Single

class TemporaryCityListRepository: CityRepository {

    private val cities = mutableListOf("Aveiro")

    override fun getCityList(): Single<List<String>> {
        return Single.just(cities)
    }

    override fun addCity(city: String) {
        cities.add(city)
    }

}