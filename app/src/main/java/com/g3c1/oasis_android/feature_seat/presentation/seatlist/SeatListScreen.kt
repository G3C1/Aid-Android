package com.g3c1.oasis_android.feature_seat.presentation.seatlist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.component.SeatSubmitButton


@Composable
fun SeatListScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        SeatSubmitButton({})
    }
}