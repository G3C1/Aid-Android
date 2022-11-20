package com.g3c1.oasis_android.feature_receipt.presentation.receipt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.g3c1.oasis_android.feature_receipt.presentation.receipt.component.ReceiptTopBar

@Composable
fun ReceiptScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ReceiptTopBar(whenUserClickGoingBack = {})
    }
}