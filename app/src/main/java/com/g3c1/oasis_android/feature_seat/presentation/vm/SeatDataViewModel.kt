package com.g3c1.oasis_android.feature_seat.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatData
import com.g3c1.oasis_android.feature_seat.domain.use_case.GetSeatDataUseCase
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeatDataViewModel @Inject constructor(
    private val getSeatDataUseCase: GetSeatDataUseCase
): ViewModel() {

    var mSeatDataList: MutableStateFlow<ApiState<SeatData>> = MutableStateFlow(ApiState.Loading())

    fun getSeatDataList() = viewModelScope.launch {
        mSeatDataList.value = ApiState.Loading()
        getSeatDataUseCase.getSeatDataUseCase().catch { error ->
            mSeatDataList.value = ApiState.Error("${error.message}")
        }.collect { value ->
            mSeatDataList.value = value
        }
    }
}