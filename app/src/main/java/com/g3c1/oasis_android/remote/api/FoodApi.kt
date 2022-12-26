package com.g3c1.oasis_android.remote.api

import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FoodApi {

    @GET("v2/food/{serial_number}")
    suspend fun getMenuList(
        @Path("serial_number") serialNumber: Long
    ): Response<List<MenuDTO>>

}