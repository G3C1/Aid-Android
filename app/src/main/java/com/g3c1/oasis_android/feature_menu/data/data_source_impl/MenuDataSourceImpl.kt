package com.g3c1.oasis_android.feature_menu.data.data_source_impl

import com.g3c1.oasis_android.di.OasisApp
import com.g3c1.oasis_android.feature_menu.data.data_soure.MenuDataSource
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.remote.api.FoodApi
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class MenuDataSourceImpl @Inject constructor(
    private val service: FoodApi
) : MenuDataSource {

    override suspend fun getMenuList(): Flow<ApiState<List<MenuDTO>>> {
        val serialNumber = OasisApp.getInstance().getSearialNumberManager().searialNumber.first()
        return flow {
            try {
                val response = service.getMenuList(serialNumber.toLong())
                if (response.isSuccessful) {
                    response.body()?.let {
                        emit(ApiState.Success(it, response.code()))
                    }
                } else {
                    try {
                        emit(ApiState.Error(response.errorBody()!!.string(), status = response.code()))
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