package com.g3c1.oasis_android.feature_menu.domain.repository_impl

import com.g3c1.oasis_android.feature_menu.data.data_soure.PurchaseDataSource
import com.g3c1.oasis_android.feature_menu.data.dto.OrderedTableInfoDTO
import com.g3c1.oasis_android.feature_menu.domain.repository.PurchaseRepository
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PurchaseRepositoryImpl @Inject constructor(
    private val dataSource: PurchaseDataSource
): PurchaseRepository {
    override suspend fun sendsTheOrderedFoodList(body: OrderedTableInfoDTO): Flow<ApiState<Unit>> {
        return dataSource.sendsTheOrderedFoodList(body = body)
    }

}