package com.g3c1.oasis_android.feature_seat.presentation.example.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatData
import com.g3c1.oasis_android.ui.theme.Orange


@Composable
fun SeatRadioButton(seatDataList: List<SeatData>) {
    val selectedValue = remember { mutableStateOf(0) }

    Column {
        seatDataList.forEach { item ->
            RadioButton(
                enabled = item.seated,
                onClick = { selectedValue.value = item.seatId },
                selected = selectedValue.value == item.seatId,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.Green,
                    unselectedColor = Orange,
                    disabledColor = Color.LightGray
                )
            )
        }
    }
}