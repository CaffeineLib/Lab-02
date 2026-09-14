package com.example.listycity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Welcome (private val modifier: Modifier) {

    @Composable
    fun show(){
        banner()
    }


    @Composable
    private fun banner(){
        Box(
            modifier = modifier
                .background(color  = Color(0xFF018577))
                .fillMaxWidth()
                .height(48.dp),
            contentAlignment = Alignment.CenterStart

        ){


            // Inside this box shall be
            insideText()
        }
    }

    @Composable
    private fun insideText(){
        Text(
            text = "ListyCity",
            color = Color.White,
            fontSize = 28.sp,
            fontFamily = FontFamily.SansSerif,
            // Anti alias "style = " taken from Gemini AI. My computer was not able to render cleanly in the emulator. Gemini suggested this fix.
            style = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false
                )),
            modifier = Modifier.padding(start = 18.dp)
        )
    }

}