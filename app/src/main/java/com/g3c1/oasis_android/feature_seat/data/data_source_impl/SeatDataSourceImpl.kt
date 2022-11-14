package com.g3c1.oasis_android.feature_seat.data.data_source_impl

import com.g3c1.oasis_android.di.OasisApp
import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatDataSource
import com.g3c1.oasis_android.feature_seat.data.dto.SeatDTO
import com.g3c1.oasis_android.remote.api.SeatApi
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class SeatDataSourceImpl @Inject constructor(
    private val service: SeatApi
) : SeatDataSource {
    override suspend fun getSeatInfo(): Flow<ApiState<List<SeatDTO>>> {
        val searialNumber = OasisApp.getInstance().getSearialNumberManager().searialNumber.first()

        return flow {
            try {
                val response = service.getSeatData(serialNumber = searialNumber.toLong())
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(ApiState.Success(it, status = response.code()))
                    }
                } else {
                    try {
                        emit(ApiState.Error(response.errorBody()!!.string(), status = 502))
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                emit(ApiState.Error(e.message ?: "", status = 501))
            } as Unit
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun patchSeatData(seatId: Int): Flow<ApiState<Unit>> {
        return flow {
            try {
                val response = service.patchSeatData(seatId)
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(ApiState.Success(it, status = response.code()))
                    }
                } else {
                    try {
                        emit(ApiState.Error(response.errorBody()!!.string(), status = 502))
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            } catch(e: Exception){
                emit(ApiState.Error(e.message ?: "", status = 501))
            } as Unit
        }.flowOn(Dispatchers.IO)    }

}