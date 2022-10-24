package com.g3c1.oasis_android.feature_menu.data.data_source_impl

import com.g3c1.oasis_android.feature_menu.data.data_soure.MenuDataSource
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.remote.api.FoodApi
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MenuDataSourceImpl @Inject constructor(
    private val service: FoodApi
) : MenuDataSource {

    override suspend fun getMenuList(): Flow<ApiState<List<MenuDTO>>> {
        return flow {
            try {
                val response = service.getMenuList()
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(ApiState.Success(it))
                    }
                } else {
                    try {
                        emit(ApiState.Error(response.errorBody()!!.string()))
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}