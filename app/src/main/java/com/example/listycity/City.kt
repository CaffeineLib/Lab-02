package com.example.listycity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class City(
    val name: String,
    isSelected: Boolean = false
) {
    var isSelected by mutableStateOf(isSelected)
}