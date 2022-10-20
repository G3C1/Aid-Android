package com.g3c1.oasis_android.feature_seat.presentation.seatlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatData
import com.g3c1.oasis_android.feature_seat.presentation.example.component.SeatRadioButton
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.component.SeatSubmitButton


@Composable
fun SeatListScreen() {
    Column(Modifier.fillMaxSize()) {
        val list = listOf(
            SeatData(
                seated = true,
                seatId = 1,
                seatNumber = 1,
                severalPeople = 4
            ),
            SeatData(
                seated = false,
                seatId = 2,
                seatNumber = 2,
                severalPeople = 4
            ),
            SeatData(
                seated = true,
                seatId = 3,
                seatNumber = 3,
                severalPeople = 4
            ),SeatData(
                seated = true,
                seatId = 4,
                seatNumber = 4,
                severalPeople = 4
            ),

        )
        SeatRadioButton(seatDataList = list)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start
        ) {
            SeatSubmitButton({})
        }
    }
}