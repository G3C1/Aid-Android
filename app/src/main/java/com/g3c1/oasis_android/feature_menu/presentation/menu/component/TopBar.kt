package com.g3c1.oasis_android.feature_menu.presentation.menu.component

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_receipt.presentation.ReceiptActivity
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Gray
import com.g3c1.oasis_android.ui.theme.Gray2
import com.g3c1.oasis_android.ui.theme.Orange

@Composable
fun TopBar(clickBackButton: () -> Unit, clickShoppingBasketButton: () -> Unit, text: String) {

    val currentActivity = LocalContext.current as Activity

    Box(
        modifier = Modifier
            .fillMaxWidth()
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
        Row(
            modifier = Modifier.align(Alignment.CenterEnd),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    currentActivity.startActivity(
                        Intent(
                            currentActivity,
                            ReceiptActivity::class.java
                        )
                    )
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_list),
                    contentDescription = "open ordered list by me",
                    tint = Gray2
                )
            }

            IconButton(
                onClick = clickShoppingBasketButton,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_cart),
                    contentDescription = "open shopping basket",
                    tint = Gray2
                )
            }
        }

    }
}