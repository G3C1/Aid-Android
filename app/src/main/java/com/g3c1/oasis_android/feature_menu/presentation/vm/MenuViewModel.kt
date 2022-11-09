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

    private val mAllMenuList = mutableStateListOf<FoodDTO>()

    val mMenuList: MutableStateFlow<ApiState<List<MenuDTO>>> = MutableStateFlow(ApiState.Loading())

    private val _orderMenuList = mutableStateListOf<OrderFoodDTO>()
    val orderMenuList: List<OrderFoodDTO> = _orderMenuList

    fun getMenuList() = viewModelScope.launch {
        mMenuList.value = ApiState.Loading()
        getMenuListUseCase.getMenuListUseCase().catch { error ->
            mMenuList.value = ApiState.Error("${error.message}")
        }.collect { value ->
            mMenuList.value = value
        }
    }

    fun checkIfFoodIsOnTheList(itemId: Int, amount: Int) {
        if (_orderMenuList.none { it.id == itemId }) {
            Log.d("TAG", "the food is not contain the list")
            addFoodToTheFoodToOrderList(itemId = itemId, amount = amount)
        } else {
            Log.d("TAG", "the food is already contain the list")
            increaseFoodAmount(itemId = itemId, count = amount)
        }
    }

    fun insertAllMenuListItems(menuList: List<MenuDTO>) {
        mAllMenuList.clear()
        menuList.forEach {
            it.foodList.forEach { menu ->
                mAllMenuList.add(menu)
            }
        }
    }

    private fun increaseFoodAmount(itemId: Int, count: Int) {
        val (id, name, img, price, amount) = _orderMenuList[getFoodPosition(itemId = itemId)]
        _orderMenuList[getFoodPosition(itemId = itemId)] =
            OrderFoodDTO(id = id, name = name, img = img, price = price, amount = count + amount)

        Log.d("TAG", "orderMenuList: $_orderMenuList")
    }

    fun decreaseFoodAmount(itemId: Int, count: Int) {
        val (id, name, img, price, amount) = _orderMenuList[getFoodPosition(itemId = itemId)]
        _orderMenuList[getFoodPosition(itemId = itemId)] =
            OrderFoodDTO(id = id, name = name, img = img, price = price, amount = amount - count)

        Log.d("TAG", "orderMenuList: $_orderMenuList")
    }

    private fun addFoodToTheFoodToOrderList(itemId: Int, amount: Int) {
        val food = mAllMenuList.first { it.id == itemId }
        _orderMenuList.add(
            OrderFoodDTO(
                id = food.id,
                name = food.name,
                price = food.price,
                img = food.img,
                amount = amount
            )
        )
    }

    private fun getFoodPosition(itemId: Int) = _orderMenuList.indexOfFirst { it.id == itemId }

}