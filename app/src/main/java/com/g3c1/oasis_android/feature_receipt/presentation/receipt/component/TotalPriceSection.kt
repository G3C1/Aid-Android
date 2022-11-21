package com.g3c1.oasis_android.feature_receipt.presentation.receipt.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.ui.theme.Font

@Composable
fun TotalPriceSection(totalPrice: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 24.dp, end = 24.dp)
    ) {
        Text(
            text = "총 액:",
            modifier = Modifier.align(Alignment.CenterStart),
            fontFamily = Font.pretendard,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
        Text(
            text = "$totalPrice 원",
            modifier = Modifier.align(Alignment.CenterEnd),
            fontFamily = Font.pretendard,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )
    }
}