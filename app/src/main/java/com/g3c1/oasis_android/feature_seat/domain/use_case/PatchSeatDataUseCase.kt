package com.g3c1.oasis_android.feature_seat.domain.use_case

import com.g3c1.oasis_android.feature_seat.domain.repository.SeatRepository
import javax.inject.Inject

class PatchSeatDataUseCase @Inject constructor(
    private val repository: SeatRepository
){
    suspend fun patchSeatDataUseCase(seatId: Int) = repository.patchSeatDataRepository(seatId)
}