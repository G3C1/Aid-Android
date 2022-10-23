package com.g3c1.oasis_android.feature_seat.domain.repository_impl

import com.g3c1.oasis_android.feature_seat.data.dto.SeatDTO
import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatDataSource
import com.g3c1.oasis_android.feature_seat.domain.repository.SeatRepository
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SeatRepositoryImpl @Inject constructor(
    private val dataSource: SeatDataSource
): SeatRepository {
    override suspend fun getSeatDataUseCase(): Flow<ApiState<List<SeatDTO>>> {
        return dataSource.getSeatInfo()
    }
}