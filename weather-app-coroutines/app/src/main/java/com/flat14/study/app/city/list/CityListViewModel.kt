package com.flat14.study.app.city.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flat14.study.domain.CitiesUseCase
import com.flat14.study.domain.GetWeatherUseCase
import com.flat14.study.domain.model.CityWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CityListViewModel(
    private val citiesUseCase: CitiesUseCase,
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _cityWeatherList = MutableLiveData<List<CityWeather>>()
    val cityWeatherList: LiveData<List<CityWeather>> = _cityWeatherList


    init {
        loadCityList()
    }

    fun loadCityList() {
        viewModelScope.launch(Dispatchers.IO) {
            val weatherList = mutableListOf<CityWeather>()
            citiesUseCase.getListOfCities().forEach { city ->
                weatherList.add(
                    getWeatherUseCase.getCurrentWeather(city)
                )
            }
            _cityWeatherList.postValue(weatherList)
        }
    }

}