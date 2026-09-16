package com.example.listycity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import com.example.listycity.ui.theme.ListyCityTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.height
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.Arrangement



class MainActivity : ComponentActivity() {
    val mycities = CityArr()
    val cityInput = CityInput()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListyCityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column(modifier = Modifier.padding(innerPadding)) {
                        Welcome(modifier = Modifier).show()
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ){
                            add_Button(cityInput, modifier = Modifier.weight(1f))
                            del_Button(mycities, modifier = Modifier.weight(1f))
                        }
                        if (cityInput.visible){
                            cityInput.inputBox(mycities)
                        }

                        CityList(_cityList = mycities.get_CityArr()).show()

                    }
                }
            }
        }
    }
}

// Credit given to Gemini AI. There isnt a propercase method inbuilt to Kotlin
fun String.toProperCase(): String {
    return this.lowercase().split(" ").joinToString(" ") { word ->
        word.replaceFirstChar { it.titlecase() }
    }
}


@Composable
fun add_Button(cityInput: CityInput, modifier: Modifier){
    Button(
        onClick = {cityInput.visible=true},
        modifier = modifier,
        shape = RoundedCornerShape(4.dp)
    ){
        Text("Add a city")
    }
}

@Composable
fun del_Button(citylist: CityArr, modifier: Modifier){
    Button(
        onClick = {citylist.del_CityBySelection()},
        modifier = modifier,
        shape = RoundedCornerShape(4.dp)

    ){
        Text("Erase a city")
    }
}

