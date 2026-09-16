package com.example.listycity

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp



class CityInput (visible: Boolean = false){
    var visible by mutableStateOf(visible)


    @Composable
    fun inputBox(citList: CityArr){

        var text by remember{ mutableStateOf("")}

        fun submit() {  //
            if (text.isNotBlank()){
                citList.insert_City(City(text))
                text =""
                visible = false
            }
        }


        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            TextField(
                value = text,
                onValueChange = {text  = it.toProperCase()},
                label  = { Text("You're Favorite City")},
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {submit()}
                ),
                modifier = Modifier
                    .weight(5f)
                    .height(56.dp)

            )
            Button (
                onClick = {submit()},
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp),

                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF018577)),
                shape = RoundedCornerShape(4.dp)

            ){
                Text("+")
            }

        }
    }
}