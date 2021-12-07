package com.flat14.study.app.city.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.flat14.study.domain.GetWeatherUseCase
import com.flat14.study.domain.model.CityWeatherForecast
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class CityDetailsViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _cityWeatherForecast = MutableLiveData<CityWeatherForecast>()
    val cityWeatherForecast: LiveData<CityWeatherForecast> = _cityWeatherForecast

    fun getWeatherForecast(cityName: String) {
        getWeatherUseCase
            .getWeatherForecast(cityName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _cityWeatherForecast.value = it
            }, {
                it.printStackTrace()
            })
    }

}