package com.example.listycity

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/* Element needs to be object to struct state.
else static function memory would work too but raises its own complication
- not an approach i want to entertain.
*/

class ListElement (
    val city: City,
    var isSelected: Boolean = false
) {

    @SuppressLint("ComposableNaming")
    @Composable
    fun make () {
        TextButton(
            onClick = {},
            shape = RectangleShape,
            colors = ButtonDefaults.textButtonColors(
                containerColor = if (isSelected) Color.LightGray else Color.Transparent
            )
        ) {
            Text(city.name,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 18.dp, vertical = 14.dp)
            )
        }
    }
}