package com.g3c1.oasis_android.feature_seat.data.data_soure

import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface SeatDataSource {
    suspend fun getSeatInfo(): Flow<ApiState<SeatData>>
}