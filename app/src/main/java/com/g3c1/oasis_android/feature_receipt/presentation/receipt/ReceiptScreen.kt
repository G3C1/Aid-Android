package com.g3c1.oasis_android.feature_receipt.presentation.receipt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.g3c1.oasis_android.feature_receipt.presentation.receipt.component.*

@Composable
fun ReceiptScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ReceiptTopBar(whenUserClickGoingBack = {})
        WaitingNumberSection(waitingNumber = "12")
        HorizontalDivider(height = 20f)
        TotalPriceSection(totalPrice = 120000)
        OrderInfoSection(list = )
    }
}