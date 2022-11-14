package com.g3c1.oasis_android.feature_menu.data.data_soure

import com.g3c1.oasis_android.feature_menu.data.dto.OrderedTableInfoDTO
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface PurchaseDataSource {
    suspend fun sendsTheOrderedFoodList(body: OrderedTableInfoDTO): Flow<ApiState<Void>>
}