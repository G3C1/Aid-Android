package com.g3c1.oasis_android.feature_menu.domain.use_case

import com.g3c1.oasis_android.feature_menu.data.dto.OrderedTableInfoDTO
import com.g3c1.oasis_android.feature_menu.domain.repository.PurchaseRepository
import javax.inject.Inject

class SendsTheOrderedFoodListUseCase @Inject constructor(
    private val repository: PurchaseRepository
){
    suspend fun sendsTheOrderedFoodListUseCase(body: OrderedTableInfoDTO) = repository.sendsTheOrderedFoodList(body = body)
}