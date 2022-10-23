package com.g3c1.oasis_android.feature_menu.domain.use_case

import com.g3c1.oasis_android.feature_menu.domain.repository.MenuRepository
import javax.inject.Inject

class GetMenuListUseCase @Inject constructor(
    private val repository: MenuRepository

) {
    suspend fun getMenuListUseCase() = repository.getMenuList()
}