package com.g3c1.oasis_android.remote.api

import com.g3c1.oasis_android.feature_select_store.data.dto.SummarizedStoreInfoDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreApi {
    @GET("v2/store/{serial_number}")
    suspend fun getStore(
        @Path("serial_number") serialNumber: Long
    ): Response<SummarizedStoreInfoDTO>
}