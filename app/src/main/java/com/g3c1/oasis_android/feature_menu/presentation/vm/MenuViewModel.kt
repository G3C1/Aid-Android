package com.g3c1.oasis_android.feature_menu.presentation.vm

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.*
import com.g3c1.oasis_android.feature_menu.data.dto.FoodDTO
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.feature_menu.data.dto.OrderFoodDTO
import com.g3c1.oasis_android.feature_menu.data.dto.OrderedTableInfoDTO
import com.g3c1.oasis_android.feature_menu.domain.use_case.GetMenuListUseCase
import com.g3c1.oasis_android.feature_menu.domain.use_case.SendsTheOrderedFoodListUseCase
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject
import kotlin.math.absoluteValue


@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getMenuListUseCase: GetMenuListUseCase,
    private val sendsTheOrderedFoodListUseCase: SendsTheOrderedFoodListUseCase
) : ViewModel() {

    private val mAllMenuList = mutableStateListOf<FoodDTO>()

    val mMenuList: MutableStateFlow<ApiState<List<MenuDTO>>> = MutableStateFlow(ApiState.Loading())

    val sendsTheOrderedTableState: MutableStateFlow<ApiState<Unit>> = MutableStateFlow(ApiState.Loading())

    private val dummyMenu = MenuDTO(
        id = 1,
        category = "테스트",
        foodList = listOf(
            FoodDTO(
                id = 1,
                name = "김현승",
                img = "https://avatars.githubusercontent.com/u/80810303?v=4",
                description = "오잇",
                servings = 99,
                price = 500
            )
        )
    )

    private val _menuList = mutableStateListOf<MenuDTO>()

    val menuList: List<MenuDTO> = _menuList

    private val _orderMenuList = mutableStateListOf<OrderFoodDTO>()
    val orderMenuList: List<OrderFoodDTO> = _orderMenuList

    fun getMenuList() = viewModelScope.launch {
        mMenuList.value = ApiState.Loading()
        getMenuListUseCase.getMenuListUseCase().catch { error ->
            mMenuList.value = ApiState.Error("${error.message}", status = 500)
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

    fun decreaseFoodAmount(itemId: Int) {
        val (id, name, img, price, amount) = _orderMenuList[getFoodPosition(itemId = itemId)]
        if(amount > 1) {
            _orderMenuList[getFoodPosition(itemId = itemId)] =
                OrderFoodDTO(id = id, name = name, img = img, price = price, amount = amount - 1)

            Log.d("TAG", "orderMenuList: $_orderMenuList")
        }
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

    fun saveTheReceivedMenuList(data: List<MenuDTO>) {
        _menuList.clear()
        data.forEach { _menuList.add(it) }
    }

    fun increaseOnlyOneAmount(itemId: Int) {
        val (id, name, img, price, amount) = _orderMenuList[getFoodPosition(itemId = itemId)]
        _orderMenuList[getFoodPosition(itemId = itemId)] =
            OrderFoodDTO(id = id, name = name, img = img, price = price, amount = amount + 1)
    }

    fun removeItemInOrderList(itemId: Int) {
        _orderMenuList.removeAt(getFoodPosition(itemId = itemId))
    }

    fun sendsTheOrderedFoodList(body: OrderedTableInfoDTO) = viewModelScope.launch {
        Log.d("TAG", "sendsTheOrderedFoodList: $body")
        sendsTheOrderedTableState.value = ApiState.Loading()
        sendsTheOrderedFoodListUseCase.sendsTheOrderedFoodListUseCase(body = body).catch { error ->
            sendsTheOrderedTableState.value = ApiState.Error("${error.message}", status = 500)
        }.collect { value ->
            sendsTheOrderedTableState.value = value
            Log.d("TAG", "sendsTheOrderedFoodListStatus: ${value.status}")
        }
    }

    fun removeAllOfOrderList() {
        _orderMenuList.clear()
    }

}