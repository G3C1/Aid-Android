package com.g3c1.oasis_android.feature_menu.presentation.shopping_basket.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Orange

@Composable
fun OrderButton(price: Int, visibility: Boolean, onClick: () -> Unit, modifier: Modifier) {
    AnimatedVisibility(visible = visibility, modifier = modifier) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(8.dp, 0.dp, 8.dp, 16.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Orange,
                contentColor = Color.White
            )
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "주문",
                    fontFamily = Font.pretendard,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
                Text(
                    text = "총액 : ${price}원",
                    fontFamily = Font.pretendard,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    }
}