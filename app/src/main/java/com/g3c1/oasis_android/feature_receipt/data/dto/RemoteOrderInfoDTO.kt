package com.g3c1.oasis_android.feature_receipt.data.dto

data class RemoteOrderInfoDTO(
    val foodList: List<RemoteOrderedMenuInfoDTO>,
    val sequence: Int
)