package com.g3c1.oasis_android.feature_seat.domain.repository

import com.g3c1.oasis_android.feature_seat.data.dto.SeatDTO
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface SeatRepository {
    suspend fun getSeatDataRepository(): Flow<ApiState<SeatDTO>>

    suspend fun patchSeatDataRepository(seatId: Int): Flow<ApiState<Unit>>
}