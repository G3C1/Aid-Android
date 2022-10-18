package com.g3c1.oasis_android.feature_seat.presentation.seatlist.component

import android.graphics.ColorMatrixColorFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Orange

@Composable
fun SeatSubmitButton(onClick: () -> Unit) {
    Button(
        onClick = { onClick },
        modifier = Modifier
            .wrapContentSize()
            .fillMaxWidth()
            .height(60.dp)
            .padding(8.dp, 0.dp, 8.dp, 16.dp)
            ,
        colors = ButtonDefaults.buttonColors(backgroundColor = Orange, contentColor = Color.White)
    ) {
        Text(text = "자리 선택", fontFamily = Font.pretendard, fontWeight = FontWeight.ExtraBold)
    }
}