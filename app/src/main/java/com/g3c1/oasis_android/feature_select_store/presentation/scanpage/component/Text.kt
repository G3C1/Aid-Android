package com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.ui.theme.Font

@Composable
fun TakeQrPicture(code: String) {
    if (code == "")
        Text(
            text = "큐알을 찍어주세요.", style = TextStyle(
                fontSize = 16.sp,
                fontFamily = Font.pretendard,
                fontWeight = FontWeight.Medium
            )
        )
}
