package com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Orange

@Composable
fun DefalutText(text: String, fontSize: TextUnit, fontWeight: FontWeight, color: Color) {
    Text(
        text = text, style = TextStyle(
            fontSize = fontSize,
            fontFamily = Font.pretendard,
            fontWeight = fontWeight,
            color = color
        )
    )
}

@Composable
fun DialogText(text: String, onClick: () -> Unit) {
    Text(modifier = Modifier
        .clickable {
            onClick()
        }
        .padding(10.dp), text = text, style = TextStyle(
        fontFamily = Font.pretendard,
        fontWeight = FontWeight.Medium,
        color = Orange,
        fontSize = 14.sp
    ))
}