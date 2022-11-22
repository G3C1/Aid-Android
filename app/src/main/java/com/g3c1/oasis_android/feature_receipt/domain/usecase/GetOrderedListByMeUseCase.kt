package com.g3c1.oasis_android.feature_receipt.domain.usecase

import com.g3c1.oasis_android.feature_receipt.domain.repository.ReceiptRepository
import javax.inject.Inject

class GetOrderedListByMeUseCase @Inject constructor(
    private val receiptRepository: ReceiptRepository
) {
    suspend fun getOrderedListByMeUseCase(seatId: Int) = receiptRepository.getOrderedListByMe(seatId)
}