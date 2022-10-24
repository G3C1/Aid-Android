package com.g3c1.oasis_android.remote.api

import com.g3c1.oasis_android.feature_seat.data.dto.SeatDTO
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.PATCH

interface SeatApi {

    @GET("/seat")
    suspend fun getSeatData(): Response<List<SeatDTO>>

    @PATCH("/seat")
    suspend fun patchSeatData(@Field("seatId")seatId: Int): Response<Unit>
}