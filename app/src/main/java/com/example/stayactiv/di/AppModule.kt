package com.example.stayactiv.di

import WeatherViewModel
import com.example.stayactiv.data.local.ActivityDatabase
import com.example.stayactiv.data.remote.WeatherApiService
import com.example.stayactiv.data.repository.WeatherRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    single {
        ActivityDatabase.getDatabase(androidContext())
    }

    single {
        get<ActivityDatabase>().activityDao()
    }
    single {
        WeatherApiService.retrofitService
    }
    single<WeatherRepository> {
        WeatherRepository(get())
    }

    viewModelOf(::WeatherViewModel)
}
