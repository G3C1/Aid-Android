package com.g3c1.oasis_android.feature_menu.domain.repository

import com.g3c1.oasis_android.feature_menu.data.dto.OrderedTableInfoDTO
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface PurchaseRepository {
    suspend fun sendsTheOrderedFoodList(body: OrderedTableInfoDTO): Flow<ApiState<Unit>>
}