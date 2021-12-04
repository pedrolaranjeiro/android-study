package com.flat14.study.app.city.add

import androidx.lifecycle.ViewModel
import com.flat14.study.domain.CitiesUseCase

class CityAddViewModel(
    private val citiesUseCase: CitiesUseCase,
) : ViewModel() {

    fun addCity(city: String) {
        citiesUseCase.addCity(city)
    }

}