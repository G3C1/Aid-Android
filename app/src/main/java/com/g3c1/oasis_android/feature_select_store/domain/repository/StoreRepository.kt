package com.g3c1.oasis_android.feature_select_store.domain.repository

import com.g3c1.oasis_android.feature_select_store.data.dto.SummarizedStoreInfoDTO
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface StoreRepository {
    suspend fun getSummarizedStoreInfo(serialNumber: Int): Flow<ApiState<SummarizedStoreInfoDTO>>
}