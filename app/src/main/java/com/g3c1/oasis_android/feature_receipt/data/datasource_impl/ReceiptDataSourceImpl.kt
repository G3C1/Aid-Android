package com.g3c1.oasis_android.feature_receipt.data.datasource_impl

import android.util.Log
import com.g3c1.oasis_android.di.OasisApp
import com.g3c1.oasis_android.feature_menu.data.dto.OrderCheckDTO
import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderInfoDTO
import com.g3c1.oasis_android.feature_receipt.domain.datasource.ReceiptDataSource
import com.g3c1.oasis_android.remote.api.PurchaseApi
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ReceiptDataSourceImpl @Inject constructor(
    private val service: PurchaseApi
) : ReceiptDataSource {
    override suspend fun getOrderedListByMe(): Flow<ApiState<RemoteOrderInfoDTO>> {

        val seatId = OasisApp.getInstance().getDataStore().text.first()
        val serialNumber = OasisApp.getInstance().getSearialNumberManager().searialNumber.first()
        Log.d("TAG", "seat Id: $seatId")
        return flow {
            try {
                val response = service.getMyOrderInfo(OrderCheckDTO(seatId = seatId.toLong(), serialNumber = serialNumber.toLong()))
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(ApiState.Success(it, response.code()))
                    }
                } else {
                    try {
                        emit(ApiState.Error(response.errorBody()!!.string(), status = response.code()))
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