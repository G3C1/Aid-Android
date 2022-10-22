package com.g3c1.oasis_android.feature_seat.domain.repository

import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatData
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface SeatRepository {
    suspend fun getSeatDataRepository(): Flow<ApiState<SeatData>>

    suspend fun patchSeatDataRepository(seatId: Int): Flow<ApiState<Unit>>
}