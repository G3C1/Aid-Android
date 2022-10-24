package com.g3c1.oasis_android.feature_menu.data.dto

data class MenuDTO(
    val id: Int,
    val category: String,
    val foodList: List<FoodDTO>
)