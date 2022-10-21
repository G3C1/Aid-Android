package com.g3c1.oasis_android.feature_seat.presentation.seatlist

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatData
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.component.SeatRadioButton
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.component.SeatSubmitButton
import com.g3c1.oasis_android.ui.theme.Orange


@Composable
fun SeatListScreen() {
    Column(Modifier.fillMaxSize()) {
        val list = listOf(
            SeatData(
                seated = true,
                seatId = 1,
                seatNumber = 1,
                severalPeople = 1
            ),
            SeatData(
                seated = false,
                seatId = 2,
                seatNumber = 2,
                severalPeople = 2
            ),
            SeatData(
                seated = false,
                seatId = 3,
                seatNumber = 3,
                severalPeople = 4
            ),
            SeatData(
                seated = false,
                seatId = 4,
                seatNumber = 4,
                severalPeople = 4
            ),

            )
        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(30.dp))
        Text(
            text = "자리선택",
            fontSize = 30.sp,
            color = Orange,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
        SeatRadioButton(seatDataList = list)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
        ) {
            SeatSubmitButton({})
        }
    }
}