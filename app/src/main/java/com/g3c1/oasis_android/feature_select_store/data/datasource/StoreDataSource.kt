package com.g3c1.oasis_android.feature_select_store.data.datasource

import com.g3c1.oasis_android.feature_select_store.data.dto.SummarizedStoreInfoDTO
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface StoreDataSource {
    suspend fun getSummarizedStoreInfo(serialNumber: Int): Flow<ApiState<SummarizedStoreInfoDTO>>
}