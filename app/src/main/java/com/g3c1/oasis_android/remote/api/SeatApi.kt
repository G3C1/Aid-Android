package com.g3c1.oasis_android.remote.api

import com.g3c1.oasis_android.feature_seat.data.dto.SeatDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface SeatApi {

    @PATCH("v1/seat/{seatId}")
    suspend fun patchSeatData(@Path("seatId")seatId: Long): Response<Unit>

    @GET("v2/seat/{serialNumber}")
    suspend fun getSeatData(@Path("serialNumber") serialNumber: Long): Response<List<SeatDTO>>
}