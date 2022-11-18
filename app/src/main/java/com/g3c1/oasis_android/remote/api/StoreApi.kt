package com.g3c1.oasis_android.remote.api

import com.g3c1.oasis_android.feature_select_store.data.dto.SummarizedStoreInfoDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreApi {
    @GET("store/{serialNumber}")
    suspend fun getStore(
        @Path("serialNumber") serialNumber: Long
    ): Response<SummarizedStoreInfoDTO>
}