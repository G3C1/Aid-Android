package com.g3c1.oasis_android.feature_receipt.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderInfoDTO
import com.g3c1.oasis_android.feature_receipt.domain.usecase.GetOrderedListByMeUseCase
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReceiptViewModel @Inject constructor(
    private val getOrderedListByMeUseCase: GetOrderedListByMeUseCase
) : ViewModel() {

    private val orderedList: MutableStateFlow<ApiState<RemoteOrderInfoDTO>> =
        MutableStateFlow(ApiState.Loading())

    fun getOrderedListByMe(seatId: Int) = viewModelScope.launch {
        orderedList.value = ApiState.Loading()
        getOrderedListByMeUseCase.getOrderedListByMeUseCase(seatId).catch { error ->
            orderedList.value = ApiState.Error("${error.message}", status = 500)
        }.collect { value ->
            orderedList.value = value
        }
    }
}