package com.g3c1.oasis_android.remote.api

import com.g3c1.oasis_android.feature_seat.data.dto.SeatDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface SeatApi {

    @PATCH("v1/seat/{seat_id}")
    suspend fun patchSeatData(@Path("seat_id")seatId: Long): Response<Unit>

    @GET("v2/seat/{serial_number}")
    suspend fun getSeatData(@Path("serial_number") serialNumber: Long): Response<List<SeatDTO>>
}