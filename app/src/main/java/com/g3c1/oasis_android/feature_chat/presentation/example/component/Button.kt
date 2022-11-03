package com.g3c1.oasis_android.feature_chat.presentation.example.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.ui.theme.Orange

@Composable
fun Menu(onClick: () -> Unit) {

    val pretendrad = FontFamily(
        Font(R.font.pretendard_semi_bold, FontWeight.SemiBold, FontStyle.Normal)
    )

    Button(
        onClick = { onClick() },
        modifier = Modifier.padding(start = 13.dp, end = 13.dp, top = 5.dp, bottom = 5.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Orange,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = "#메뉴판", style = TextStyle(
                fontFamily = pretendrad,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 15.sp
            )
        )
    }
}

@Composable
fun SendBtn(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .width(50.dp)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Orange, contentColor = Color.White
        )
    ) {
        Image(painterResource(id = R.drawable.send_btn), contentDescription = null)
    }
}