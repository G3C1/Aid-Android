package com.g3c1.oasis_android.feature_receipt.presentation.receipt

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderInfoDTO
import com.g3c1.oasis_android.feature_receipt.presentation.receipt.component.*

@Composable
fun ReceiptScreen(data: RemoteOrderInfoDTO) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val currentActivity = LocalContext.current as Activity
        val sequence = data.sequence
        val totalPrice = data.foodInfoList.sumOf { it.price * it.foodCount }
        val list = data.foodInfoList
//        val dummyData = RemoteOrderInfoDTO(
//            sequence = 1,
//            foodList = listOf(
//                RemoteOrderedMenuInfoDTO(
//                    foodName = "치킨",
//                    foodCount = 2,
//                    foodImg = "https://avatars.githubusercontent.com/u/80810303?v=4",
//                    price = 18000,
//                    servings = 2
//                ),
//                RemoteOrderedMenuInfoDTO(
//                    foodName = "치킨",
//                    foodCount = 2,
//                    foodImg = "https://avatars.githubusercontent.com/u/80810303?v=4",
//                    price = 18000,
//                    servings = 2
//                )
//            )
//        )

        ReceiptTopBar(whenUserClickGoingBack = {
            currentActivity.finish()
        })
        WaitingNumberSection(waitingNumber = sequence.toString())
        HorizontalDivider(height = 20f)
        TotalPriceSection(totalPrice = totalPrice)
        OrderInfoSection(list = list)
    }
}