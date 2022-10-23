package com.g3c1.oasis_android.feature_menu.data.data_soure

import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow

interface MenuDataSource {

    suspend fun getMenuList(): Flow<ApiState<List<MenuDTO>>>
}