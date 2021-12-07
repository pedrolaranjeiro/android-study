package com.flat14.study.domain

interface CityRepository {

    suspend fun getCityList(): List<String>

    suspend fun addCity(city: String)

}