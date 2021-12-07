package com.flat14.study.app.city.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flat14.study.domain.CitiesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityAddViewModel(
    private val citiesUseCase: CitiesUseCase,
) : ViewModel() {

    fun addCity(city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            citiesUseCase.addCity(city)
        }
    }

}