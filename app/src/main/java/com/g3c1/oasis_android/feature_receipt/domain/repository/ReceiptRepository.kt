package com.g3c1.oasis_android.feature_receipt.domain.repository

import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderInfoDTO
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface ReceiptRepository {

    suspend fun getOrderedListByMe(): Flow<ApiState<RemoteOrderInfoDTO>>
}