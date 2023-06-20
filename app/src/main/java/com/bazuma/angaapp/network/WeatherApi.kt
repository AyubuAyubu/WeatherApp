package com.bazuma.angaapp.network

import com.bazuma.angaapp.model.Weather
import com.bazuma.angaapp.model.WeatherObject
import com.bazuma.angaapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

//step 4 use internal by retrofit
@Singleton
interface WeatherApi {
    @GET(value ="/data/2.5/forecast/daily")
    suspend fun getWeather(
        @Query("q") query:String,
        @Query("units") units:String="imperial",
        @Query("appid") appid:String= Constants.API_KEY
    ): Weather
}