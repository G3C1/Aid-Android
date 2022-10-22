package com.g3c1.oasis_android.remote.api

import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatData
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.PUT

interface SeatApi {

    @GET("/seat")
    suspend fun getSeatData(): Response<SeatData>

    @PATCH("/seat")
    suspend fun patchSeatData(@Field("seatId")seatId: Int): Response<Unit>
}