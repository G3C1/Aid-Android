package com.g3c1.oasis_android.feature_menu.data.dto

data class OrderedTableInfoDTO(
    val serialNumber: Long,
    val seatId: Long,
    val foodList: List<OrderInfoDTO>
)
