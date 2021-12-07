package com.flat14.study.app.city.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flat14.study.domain.GetWeatherUseCase
import com.flat14.study.domain.model.CityWeatherForecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityDetailsViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _cityWeatherForecast = MutableLiveData<CityWeatherForecast>()
    val cityWeatherForecast: LiveData<CityWeatherForecast> = _cityWeatherForecast

    fun getWeatherForecast(cityName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val cityWeatherForecast = getWeatherUseCase.getWeatherForecast(cityName)
            _cityWeatherForecast.postValue(cityWeatherForecast)
        }
    }

}