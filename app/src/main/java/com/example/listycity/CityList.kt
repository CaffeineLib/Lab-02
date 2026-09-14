package com.example.listycity

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items

class CityList (
    private val _cityList:List<City>
){

//    var selectionCity: Int = 0 // for future use

    @Composable
    fun show(){
        cityLazyLister()
    }

    @Composable
    private fun rowItem(city:City) {
        Text(
            text = city.name,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 14.dp)
        )
    }

    @Composable
    private fun cityLazyLister() {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items= _cityList) {
                rowItem(it)
                HorizontalDivider(color = Color.LightGray, thickness = 0.5.dp)
            }
        }
    }

}