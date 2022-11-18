package com.g3c1.oasis_android.remote.api

import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import retrofit2.Response
import retrofit2.http.GET

interface FoodApi {

    @GET("v1/food/")
    suspend fun getMenuList(): Response<List<MenuDTO>>
}