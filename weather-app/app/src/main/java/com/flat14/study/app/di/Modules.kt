package com.flat14.study.app.di

import com.flat14.study.app.CityListFragment
import com.flat14.study.app.CityListViewModel
import com.flat14.study.data.OpenWeatherRepository
import com.flat14.study.data.TemporaryCityListRepository
import com.flat14.study.data.WeatherAPI
import com.flat14.study.data.weatherClient
import com.flat14.study.domain.CityRepository
import com.flat14.study.domain.GetCitiesUseCase
import com.flat14.study.domain.GetWeatherUseCase
import com.flat14.study.domain.WeatherRepository
import org.koin.androidx.fragment.dsl.fragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    factory { weatherClient() }

    single<WeatherRepository> { OpenWeatherRepository(get()) }

    single<CityRepository> { TemporaryCityListRepository() }

    single { GetCitiesUseCase(get()) }

    single { GetWeatherUseCase(get()) }

    viewModel { CityListViewModel(get(), get()) }

}