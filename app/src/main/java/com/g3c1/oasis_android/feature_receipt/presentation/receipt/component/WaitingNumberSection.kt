package com.g3c1.oasis_android.feature_receipt.presentation.receipt.component

import androidx.compose.foundation.layout.*
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
fun WaitingNumberSection(waitingNumber: String) {
    Column(
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "고객님 차례까지 ${waitingNumber}명 남았어요.",
            textAlign = TextAlign.Center,
            modifier = Modifier,
            fontFamily = Font.pretendard,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "이 페이지는 장바구니에서 다시 보실 수 있습니다.",
            textAlign = TextAlign.Center,
            modifier = Modifier,
            fontFamily = Font.pretendard,
            fontSize = 15.sp,
            color = Color.DarkGray
        )
    }

}