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
import androidx.compose.material3.TextButton
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.MutableState


class CityList (
    private val _cityList: SnapshotStateList<City>
){
    @Composable
    fun show(){
        cityLazyLister()
    }

    @Composable
    private fun cityLazyLister() {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(items= _cityList) {a ->
                ListElement(a).make()
                HorizontalDivider(color = Color.LightGray, thickness = 0.5.dp)
            }
        }
    }




}