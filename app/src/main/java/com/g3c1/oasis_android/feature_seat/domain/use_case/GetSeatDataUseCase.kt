package com.g3c1.oasis_android.feature_seat.domain.use_case

import com.g3c1.oasis_android.feature_seat.domain.repository.SeatRepository
import javax.inject.Inject

class GetSeatDataUseCase @Inject constructor(
    private val repository: SeatRepository
) {
    suspend fun getSeatDataUseCase() = repository.getSeatDataUseCase()
}