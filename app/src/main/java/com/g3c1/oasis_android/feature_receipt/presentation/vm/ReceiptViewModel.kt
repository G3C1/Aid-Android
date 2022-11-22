package com.g3c1.oasis_android.feature_receipt.presentation.vm

import androidx.lifecycle.ViewModel
import com.g3c1.oasis_android.feature_receipt.domain.usecase.GetOrderedListByMeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReceiptViewModel @Inject constructor(
    private val getOrderedListByMeUseCase: GetOrderedListByMeUseCase
): ViewModel() {
    
}