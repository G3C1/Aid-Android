package com.g3c1.oasis_android.feature_receipt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.g3c1.oasis_android.feature_receipt.presentation.receipt.ReceiptScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReceiptActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReceiptScreen()
        }
    }
}