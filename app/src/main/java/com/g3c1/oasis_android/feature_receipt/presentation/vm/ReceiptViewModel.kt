package com.g3c1.oasis_android.feature_receipt.presentation.vm

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderInfoDTO
import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderedMenuInfoDTO
import com.g3c1.oasis_android.feature_receipt.domain.usecase.GetOrderedListByMeUseCase
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReceiptViewModel @Inject constructor(
    private val getOrderedListByMeUseCase: GetOrderedListByMeUseCase
) : ViewModel() {

    private val _orderedList: MutableStateFlow<ApiState<RemoteOrderInfoDTO>> =
        MutableStateFlow(ApiState.Loading())

    val orderedList = mutableStateOf(RemoteOrderInfoDTO(
        sequence = 0,
        foodInfoList = listOf(RemoteOrderedMenuInfoDTO(foodName = "", foodImg = "", price = 0, servings = 0, foodCount = 0))
    ))


    fun getOrderedListByMe() = viewModelScope.launch {
        _orderedList.value = ApiState.Loading()
        getOrderedListByMeUseCase.getOrderedListByMeUseCase().catch { error ->
            Log.d("GetOrderListByMe", "${error.message}")
            _orderedList.value = ApiState.Error("${error.message}", status = 500)
        }.collect { value ->
            Log.d("GetOrderListByMe", "${value.data}")
            _orderedList.value = value
            orderedList.value = value.data!!
        }
    }
}