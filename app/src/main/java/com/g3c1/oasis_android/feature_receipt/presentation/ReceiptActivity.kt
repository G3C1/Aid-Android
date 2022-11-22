package com.g3c1.oasis_android.feature_receipt.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.g3c1.oasis_android.feature_receipt.presentation.receipt.ReceiptScreen
import com.g3c1.oasis_android.feature_receipt.presentation.vm.ReceiptViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ReceiptActivity : ComponentActivity() {
    private val receiptViewModel by viewModels<ReceiptViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        receiptViewModel.getOrderedListByMe()
        setContent {
            ReceiptScreen(
                receiptViewModel = viewModel(LocalContext.current as ReceiptActivity)
            )
        }
    }
}