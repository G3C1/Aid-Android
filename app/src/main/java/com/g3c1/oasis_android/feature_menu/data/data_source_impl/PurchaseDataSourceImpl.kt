package com.g3c1.oasis_android.feature_menu.data.data_source_impl

import com.g3c1.oasis_android.feature_menu.data.data_soure.PurchaseDataSource
import com.g3c1.oasis_android.feature_menu.data.dto.OrderedTableInfoDTO
import com.g3c1.oasis_android.remote.api.PurchaseApi
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class PurchaseDataSourceImpl @Inject constructor(
    private val service: PurchaseApi
) : PurchaseDataSource {

    override suspend fun sendsTheOrderedFoodList(body: OrderedTableInfoDTO): Flow<ApiState<Void>> {
        return flow {
            try {
                val response = service.sendsTheOrderedFoodListToTheServer(body = body)
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(ApiState.Success(it, response.code()))
                    }
                } else {
                    try {
                        emit(ApiState.Error(response.errorBody().toString(), status = response.code()))
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}