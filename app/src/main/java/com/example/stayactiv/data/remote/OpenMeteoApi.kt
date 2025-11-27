package com.example.stayactiv.data.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object OpenMeteoApi {
    private const val BASE_URL = "https://api.open-meteo.com/"

    val retrofitService: OpenMeteoApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(OpenMeteoApiService::class.java)
    }
}
