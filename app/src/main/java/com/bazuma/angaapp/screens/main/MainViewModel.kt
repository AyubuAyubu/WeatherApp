package com.bazuma.angaapp.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bazuma.angaapp.data.DataOrException
import com.bazuma.angaapp.model.Weather
import com.bazuma.angaapp.model.WeatherObject
import com.bazuma.angaapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository:WeatherRepository):ViewModel() {
    val data:MutableState<DataOrException<Weather,Boolean,Exception>> =
        mutableStateOf(DataOrException(null,true,Exception("")))

    init {
        loadWeather()
    }

    private fun loadWeather() {
        getWeather("Seattle")
    }

    private fun getWeather(city: String) {
        viewModelScope.launch {
            if (city.isEmpty()) return@launch
            data.value.loading=true
            data.value=repository.getWeather(cityQuery = city)

            if (data.value.data.toString().isNotEmpty())
                data.value.loading=false
        }
    }
}