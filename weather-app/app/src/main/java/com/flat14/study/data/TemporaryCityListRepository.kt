package com.flat14.study.data

import com.flat14.study.domain.CityRepository
import io.reactivex.rxjava3.core.Single

class TemporaryCityListRepository: CityRepository {
    override fun getCityList(): Single<List<String>> {
        return Single.just(listOf("Aveiro"))
    }
}