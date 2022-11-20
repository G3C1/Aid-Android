package com.g3c1.oasis_android.feature_receipt.presentation.receipt.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component.PretendardText
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Gray2

@Composable
fun ReceiptTopBar(whenUserClickGoingBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(start = 13.dp, end = 13.dp)
    ) {
        IconButton(
            onClick = whenUserClickGoingBack,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                contentDescription = "backButton",
                tint = Gray2
            )
        }

        Text(
            text = "내 주문 보기",
            fontSize = 24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = Font.pretendard,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}