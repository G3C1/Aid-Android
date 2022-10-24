package com.g3c1.oasis_android.feature_menu.domain.repository

import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface MenuRepository {
    suspend fun getMenuList(): Flow<ApiState<List<MenuDTO>>>
}