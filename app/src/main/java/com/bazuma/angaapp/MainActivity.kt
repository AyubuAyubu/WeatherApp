package com.bazuma.angaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bazuma.angaapp.navigation.WeatherNavigation
import com.bazuma.angaapp.ui.theme.AngaAppTheme
import dagger.hilt.android.AndroidEntryPoint

//step 2 use weather navigation
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Call Weather App and set weather navigation which knows where to start
            //Then we see our screens
            WeatherApp()
        }
    }
}
@Composable
fun WeatherApp(){
    AngaAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            //step 3 restructure the project

            Column(verticalArrangement = Arrangement.Center,
             horizontalAlignment = Alignment.CenterHorizontally)
             {
                 WeatherNavigation()
             }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AngaAppTheme {

    }
}