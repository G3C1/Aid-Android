package com.g3c1.oasis_android.feature_receipt.domain.datasource

import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderInfoDTO
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface ReceiptDataSource {
    suspend fun getOrderedListByMe(seatId: Int): Flow<ApiState<RemoteOrderInfoDTO>>
}