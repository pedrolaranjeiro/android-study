package com.flat14.study.app.city.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.flat14.study.domain.CitiesUseCase
import com.flat14.study.domain.GetWeatherUseCase
import com.flat14.study.domain.model.CityWeather
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable.fromIterable
import io.reactivex.rxjava3.schedulers.Schedulers

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
        citiesUseCase.getListOfCities()
            .flatMapObservable { cityList -> fromIterable(cityList) }
            .flatMapSingle { city -> getWeatherUseCase.getCurrentWeather(city) }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { weatherList ->
                    _cityWeatherList.value = weatherList
                }, {
                    it.printStackTrace()
                })
    }

}