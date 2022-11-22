package com.g3c1.oasis_android.feature_receipt.domain.datasource

import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderInfoDTO
import kotlinx.coroutines.flow.Flow

interface ReceiptDataSource {
    suspend fun getOrderedListByMe(): Flow<RemoteOrderInfoDTO>
}