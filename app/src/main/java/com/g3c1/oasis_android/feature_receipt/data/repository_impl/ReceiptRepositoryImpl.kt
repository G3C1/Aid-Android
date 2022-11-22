package com.g3c1.oasis_android.feature_receipt.data.repository_impl

import com.g3c1.oasis_android.feature_receipt.domain.datasource.ReceiptDataSource
import com.g3c1.oasis_android.feature_receipt.domain.repository.ReceiptRepository
import javax.inject.Inject

class ReceiptRepositoryImpl @Inject constructor(
    private val datasource: ReceiptDataSource
) : ReceiptRepository {
    override suspend fun getOrderedListByMe(seatId: Int) = datasource.getOrderedListByMe(seatId)
}