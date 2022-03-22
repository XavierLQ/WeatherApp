package com.example.myweatherappcat22.rest

import com.example.myweatherappcat22.model.Results
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET(FORECAST_PATH)
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appId") apiKey: String = API_KEY
    ): Response<Results>

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
        private const val FORECAST_PATH = "data/2.5/forecast"

        private const val API_KEY = "424e3a85c1bbe27d35b93bfa09729939"
    }
}