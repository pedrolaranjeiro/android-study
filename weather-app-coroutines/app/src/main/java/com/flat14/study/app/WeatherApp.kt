package com.flat14.study.app

import android.app.Application
import com.flat14.study.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@WeatherApp)
            modules(appModule)
        }
    }
}