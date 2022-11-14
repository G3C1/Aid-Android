package com.g3c1.oasis_android.remote.api

import com.g3c1.oasis_android.feature_menu.data.dto.OrderedTableInfoDTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface PurchaseApi {

    @POST("v1/purchase/")
    suspend fun sendsTheOrderedFoodListToTheServer(@Body body: OrderedTableInfoDTO): Response<Void>
}