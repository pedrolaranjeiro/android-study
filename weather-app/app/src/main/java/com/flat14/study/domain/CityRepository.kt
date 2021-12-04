package com.flat14.study.domain

import io.reactivex.rxjava3.core.Single

interface CityRepository {

    fun getCityList(): Single<List<String>>

    fun addCity(city: String)

}