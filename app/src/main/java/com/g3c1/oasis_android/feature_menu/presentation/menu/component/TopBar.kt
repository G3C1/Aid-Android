package com.g3c1.oasis_android.feature_menu.presentation.menu.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Gray2
import com.g3c1.oasis_android.ui.theme.Orange

@Composable
fun TopBar(clickBackButton: () -> Unit, clickShoppingBasketButton: () -> Unit, text: String) {

    Box(modifier = Modifier.fillMaxWidth()
        .fillMaxHeight(0.076f)
    ) {
        IconButton(onClick = clickBackButton, modifier = Modifier.align(Alignment.CenterStart)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_back_ios_24),
                contentDescription = "backButton",
                tint = Gray2
            )
        }
        Text(
            text = text,
            modifier = Modifier.align(Alignment.Center),
            fontFamily = Font.pretendard,
            fontSize = 20.sp,
            color = Orange
        )
        IconButton(onClick = clickShoppingBasketButton, modifier = Modifier.align(Alignment.CenterEnd)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_cart),
                contentDescription = "open shopping basket",
                tint = Gray2
            )
        }
    }
}