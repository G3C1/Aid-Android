package com.g3c1.oasis_android.feature_chat.presentation.example.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.ui.theme.Gray8

@Composable
fun TopBar(tableNum: String) {
    val pretendard = FontFamily(
        Font(R.font.pretendard_semi_bold, FontWeight.SemiBold, FontStyle.Normal)
    )

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 12.dp)
    ) {
        Text(
            text = "${tableNum}번 자리", style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp,
                fontFamily = pretendard,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal
            )
        )
    }
    Canvas(modifier = Modifier.fillMaxWidth()) {
        drawLine(
            start = Offset(x = 0f, y = 0f), end = Offset(x = size.width, y = 0f), color = Gray8
        )
    }
}