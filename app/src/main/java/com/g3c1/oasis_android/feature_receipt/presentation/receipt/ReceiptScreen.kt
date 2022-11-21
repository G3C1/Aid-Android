package com.g3c1.oasis_android.feature_receipt.presentation.receipt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderInfoDTO
import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderedMenuInfoDTO
import com.g3c1.oasis_android.feature_receipt.presentation.receipt.component.*

@Composable
fun ReceiptScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val dummyData = RemoteOrderInfoDTO(
            sequence = 1,
            foodList = listOf(
                RemoteOrderedMenuInfoDTO(
                    foodName = "치킨",
                    foodCount = 2,
                    foodImg = "https://avatars.githubusercontent.com/u/80810303?v=4",
                    price = 18000,
                    servings = 2
                ),
                RemoteOrderedMenuInfoDTO(
                    foodName = "치킨",
                    foodCount = 2,
                    foodImg = "https://avatars.githubusercontent.com/u/80810303?v=4",
                    price = 18000,
                    servings = 2
                )
            )
        )
        ReceiptTopBar(whenUserClickGoingBack = {})
        WaitingNumberSection(waitingNumber = "12")
        HorizontalDivider(height = 20f)
        TotalPriceSection(totalPrice = 120000)
        OrderInfoSection(list = dummyData.foodList)
    }
}