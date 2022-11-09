package com.g3c1.oasis_android.feature_menu.presentation.vm

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.*
import com.g3c1.oasis_android.feature_menu.data.dto.FoodDTO
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.feature_menu.data.dto.OrderFoodDTO
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

    val orderMenuList = mutableStateListOf<OrderFoodDTO>()

    val mAllMenuList = mutableStateListOf<FoodDTO>()

    fun getMenuList() = viewModelScope.launch {
        mMenuList.value = ApiState.Loading()
        getMenuListUseCase.getMenuListUseCase().catch { error ->
            mMenuList.value = ApiState.Error("${error.message}")
        }.collect { value ->
            mMenuList.value = value
        }
    }

    fun increaseFoodAmount(itemId: Int, count: Int) {
        val (id, name, img, price, amount) = orderMenuList[getFoodPosition(itemId = itemId)]
        orderMenuList[getFoodPosition(itemId = itemId)] =
            OrderFoodDTO(id = id, name = name, img = img, price = price, amount = count + amount)

        Log.d("TAG", "orderMenuList: $orderMenuList")
    }

    private fun getFoodPosition(itemId: Int) = orderMenuList.indexOfFirst { it.id == itemId }

    fun deleteItem(itemId: Int) {
        orderMenuList.remove(orderMenuList.filter { it.id == itemId }[0])
    }


}