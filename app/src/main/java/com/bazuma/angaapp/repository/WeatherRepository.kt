package com.bazuma.angaapp.repository

import com.bazuma.angaapp.data.DataOrException
import com.bazuma.angaapp.model.Weather
import com.bazuma.angaapp.model.WeatherObject
import com.bazuma.angaapp.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery:String)
    :DataOrException<Weather,Boolean,Exception> {
        val response = try {
                api.getWeather(query = cityQuery)
            }catch (e:Exception){
                return DataOrException(e=e)
            }
            return DataOrException(data = response)

    }
}