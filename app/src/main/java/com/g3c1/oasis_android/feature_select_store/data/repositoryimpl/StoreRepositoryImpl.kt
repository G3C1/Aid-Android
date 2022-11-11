package com.g3c1.oasis_android.feature_select_store.data.repositoryimpl

import com.g3c1.oasis_android.feature_select_store.data.datasource.StoreDataSource
import com.g3c1.oasis_android.feature_select_store.data.dto.SummarizedStoreInfoDTO
import com.g3c1.oasis_android.feature_select_store.domain.repository.StoreRepository
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val dataSource: StoreDataSource
) : StoreRepository {
    override suspend fun getSummarizedStoreInfo(serialNumber: Int): Flow<ApiState<SummarizedStoreInfoDTO>> {
        return dataSource.getSummarizedStoreInfo(serialNumber)
    }
}