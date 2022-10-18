package com.g3c1.oasis_android.feature_seat.presentation.example.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun SeatRadioButton() {
    val selectedValue = remember { mutableStateOf("")}
}