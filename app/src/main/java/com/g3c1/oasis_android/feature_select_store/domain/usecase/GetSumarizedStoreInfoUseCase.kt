package com.g3c1.oasis_android.feature_select_store.domain.usecase

import com.g3c1.oasis_android.feature_select_store.domain.repository.StoreRepository
import javax.inject.Inject

class GetSumarizedStoreInfoUseCase @Inject constructor(
    private val repository: StoreRepository
) {
    suspend fun getSumarizedStoreInfo() =
        repository.getSummarizedStoreInfo()
}