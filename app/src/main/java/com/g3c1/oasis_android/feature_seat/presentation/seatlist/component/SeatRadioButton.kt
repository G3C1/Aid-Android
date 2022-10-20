package com.g3c1.oasis_android.feature_seat.presentation.example.component

import androidx.compose.material.IconToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember


@Composable
fun SeatRadioButton() {
    val selectedValue = remember { mutableStateOf("") }

    IconToggleButton(checked = selectedValue.value == , onCheckedChange = selectedValue.value ) {

    }
}