package com.g3c1.oasis_android.feature_menu.domain.repository_impl

import com.g3c1.oasis_android.feature_menu.data.data_soure.MenuDataSource
import com.g3c1.oasis_android.feature_menu.domain.repository.MenuRepository
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val datasource: MenuDataSource
): MenuRepository {
    override suspend fun getMenuList() = datasource.getMenuList()
}