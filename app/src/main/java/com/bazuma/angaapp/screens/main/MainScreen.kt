package com.bazuma.angaapp.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.bazuma.angaapp.data.DataOrException
import com.bazuma.angaapp.model.Weather
import com.bazuma.angaapp.widgets.WeatherAppBar
import java.lang.Exception

@Composable
fun MainScreen(navController: NavController,
               mainViewModel: MainViewModel){

    val weatherData = produceState<DataOrException<Weather,Boolean,Exception>>(
        initialValue = DataOrException(loading = true)){
        value = mainViewModel.data.value
    }.value

    if (weatherData.loading == true){
        CircularProgressIndicator()
    }else if(weatherData.data != null){
        //Text(text = "Main Screen ${weatherData.data!!.city.country}")
         MainScaffold(weather=weatherData.data!!,navController)

    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScaffold(weather: Weather,
                 navController: NavController) {
    Scaffold(topBar = {
        WeatherAppBar(
            title = weather.city.name + " ,${weather.city.country}",
            icon= Icons.Default.ArrowBack,
            navController = navController,
            elevation = 5.dp
            ){
            
        }
    }){
         MainContent(data=weather)
    }
}

@Composable
fun MainContent(data:Weather) {
    val imageUrl="https://openweathermap.org/img/wn/${data!!.list[0].weather[0].icon}.png"
   Column(
       Modifier
           .padding(4.dp)
           .fillMaxWidth(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
        Text(
            text = "Nov 29",
            style = MaterialTheme.typography.caption,
            color=MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(6.dp)
        )
       Surface(
           modifier = Modifier
               .padding(4.dp)
               .size(200.dp),
           shape = CircleShape,
           color = Color(0xFFFFC400)
       ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherStateImage(imageUrl=imageUrl)
                Text(text = "56",style=MaterialTheme.typography.h4, fontWeight = FontWeight.ExtraBold)
                Text(text = "Snow", fontStyle = FontStyle.Italic)
            }
       }
   }
}

@Composable
fun WeatherStateImage(imageUrl: String) {
       Image(
           painter = rememberImagePainter(imageUrl ),
           contentDescription = "icon image",
           modifier =Modifier.size(80.dp)
           )
}
