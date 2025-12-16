package com.example.stayactiv.data.repository

import android.util.Log
import coil3.util.Logger
import com.example.stayactiv.data.model.WeatherData
import com.example.stayactiv.data.model.WeatherMapper
import com.example.stayactiv.data.remote.ApiErrorHandler
import com.example.stayactiv.data.remote.OpenMeteoApi
import com.example.stayactiv.data.remote.WeatherApiService

class WeatherRepository(  private val api: OpenMeteoApi = WeatherApiService.retrofitService
) {


    suspend fun getWeather(lat: Double, lon: Double): Result<WeatherData> {
        return try {
            val response = api.getWeather(
                latitude = lat,
                longitude = lon
            )

            // Domain-Mapping (heute + morgen)
            val mapped = WeatherMapper.mapToDomain(response)

            Result.success(mapped)

        } catch (e: retrofit2.HttpException) {
            Result.failure(Exception(ApiErrorHandler.getErrorMessage(e.code())))
        } catch (e: java.io.IOException) {
            Result.failure(Exception(ApiErrorHandler.getNetworkErrorMessage()))
        } catch (e: Exception) {
            Log.e("WeatherRepository", e.message.toString())
            Result.failure(Exception(ApiErrorHandler.getUnexpectedErrorMessage()))
        }
    }
}
