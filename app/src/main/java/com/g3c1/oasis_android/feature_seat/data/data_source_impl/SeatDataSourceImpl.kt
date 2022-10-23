package com.g3c1.oasis_android.feature_seat.data.data_source_impl

import com.g3c1.oasis_android.feature_seat.data.dto.SeatDTO
import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatDataSource
import com.g3c1.oasis_android.remote.api.SeatApi
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import javax.inject.Inject

class SeatDataSourceImpl @Inject constructor(
    private val service: SeatApi
): SeatDataSource {

    override suspend fun getSeatInfo(): Flow<ApiState<SeatDTO>> {
        return flow {
            try {
                val response = service.getSeatData()
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(ApiState.Success(it))
                    }
                } else {
                    try {
                        emit(ApiState.Error(response.errorBody()!!.string()))
                    }   catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }   catch (e: Exception) {
                emit(ApiState.Error(e.message ?: ""))
            } as Unit
        }.flowOn(Dispatchers.IO)
    }
}