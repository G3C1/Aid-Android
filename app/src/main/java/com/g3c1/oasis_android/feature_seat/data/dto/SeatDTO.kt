package com.g3c1.oasis_android.feature_seat.data.dto

data class SeatDTO(
    val seatId: Long,
    val seatNumber: Int,
    val severalPeople: Int,
    val x: Float,
    val y: Float,
    val enabled: Boolean,
)
