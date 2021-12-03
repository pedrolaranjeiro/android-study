package com.flat14.study.data

import com.flat14.study.data.model.OpenCityWeather
import io.reactivex.rxjava3.core.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val API_KEY = "81be2d27f9d9bc735598c8aadaaa3d22"
private const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

fun weatherClient(): WeatherAPI {
    val client = OkHttpClient()

    //FIXME
//    client.interceptors().add(Interceptor { chain ->
//        val request = chain.request()
//        val url = request.url().newBuilder().addQueryParameter("APPID", API_KEY).build()
//        request.newBuilder().url(url).build()
//        chain.proceed(request)
//    })

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .build()
    return retrofit.create(WeatherAPI::class.java)
}

interface WeatherAPI {

    @GET("weather?units=metric")
    fun getWeatherForCity(@Query("q") city: String): Single<OpenCityWeather>

}