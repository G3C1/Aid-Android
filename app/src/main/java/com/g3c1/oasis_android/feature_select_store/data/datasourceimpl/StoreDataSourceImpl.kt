package com.g3c1.oasis_android.feature_select_store.data.datasourceimpl

import com.g3c1.oasis_android.feature_select_store.data.datasource.StoreDataSource
import com.g3c1.oasis_android.feature_select_store.data.dto.SummarizedStoreInfoDTO
import com.g3c1.oasis_android.remote.api.StoreApi
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class StoreDataSourceImpl @Inject constructor(
    private val api: StoreApi
) : StoreDataSource {
    override suspend fun getSummarizedStoreInfo(serialNumber: Int): Flow<ApiState<SummarizedStoreInfoDTO>> {
        return flow {
            try {
                val response = api.getStore(serialNumber = serialNumber)
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(ApiState.Success(it))
                    }
                } else {
                    try {
                        emit(ApiState.Error(response.errorBody()!!.string()))
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                emit(ApiState.Error(e.message ?: ""))
            } as Unit
        }.flowOn(Dispatchers.IO)
    }
}