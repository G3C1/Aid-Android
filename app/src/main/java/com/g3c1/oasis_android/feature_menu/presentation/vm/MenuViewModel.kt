package com.g3c1.oasis_android.feature_menu.presentation.vm

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.g3c1.oasis_android.feature_menu.data.dto.FoodDTO
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.feature_menu.domain.use_case.GetMenuListUseCase
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getMenuListUseCase: GetMenuListUseCase
) : ViewModel() {

    val mMenuList: MutableStateFlow<ApiState<List<MenuDTO>>> = MutableStateFlow(ApiState.Loading())

    val orderMenuList = mutableMapOf<Int, Int>()

    val mAllMenuList = mutableStateListOf<FoodDTO>()

    fun getMenuList() = viewModelScope.launch {
        mMenuList.value = ApiState.Loading()
        getMenuListUseCase.getMenuListUseCase().catch { error ->
            mMenuList.value = ApiState.Error("${error.message}")
        }.collect { value ->
            mMenuList.value = value
        }
    }

    fun increaseCount(itemId: Int, count: Int) {
        orderMenuList[itemId] =
            count + if (orderMenuList[itemId] == null) 0 else orderMenuList[itemId]!!

        Log.d("TAG", "orderMenuList: $orderMenuList")
    }

    fun deleteItem(itemId: Int) {
        orderMenuList.remove(itemId)
    }


}