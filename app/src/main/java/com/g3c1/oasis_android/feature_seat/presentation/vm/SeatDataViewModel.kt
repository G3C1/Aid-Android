package com.g3c1.oasis_android.feature_seat.presentation.vm

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.g3c1.oasis_android.feature_seat.data.dto.SeatDTO
import com.g3c1.oasis_android.feature_seat.domain.use_case.GetSeatDataUseCase
import com.g3c1.oasis_android.feature_seat.domain.use_case.PatchSeatDataUseCase
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeatDataViewModel @Inject constructor(
    private val getSeatDataUseCase: GetSeatDataUseCase,
    private val patchSeatData: PatchSeatDataUseCase
): ViewModel() {

    val selectedSeatId = mutableStateOf(0)
    val mSeatDataList: MutableStateFlow<ApiState<List<SeatDTO>>> = MutableStateFlow(ApiState.Loading())
    val mPatchSeatDataResult: MutableStateFlow<ApiState<Unit>> = MutableStateFlow(ApiState.Loading())

    fun getSeatDataList() = viewModelScope.launch {
        mSeatDataList.value = ApiState.Loading()
        getSeatDataUseCase.getSeatDataUseCase().catch { error ->
            mSeatDataList.value = ApiState.Error("${error.message}", status = 503)
        }.collect { value ->
            mSeatDataList.value = value
        }
    }

    fun patchSeatData(seatId: Long) = viewModelScope.launch {
        selectedSeatId.value - seatId
        mPatchSeatDataResult.value = ApiState.Loading()
        patchSeatData.patchSeatDataUseCase(seatId).catch { error ->
            mPatchSeatDataResult.value = ApiState.Error("${error.message}", status = 503)
        }.collect { value ->
            mPatchSeatDataResult.value = value
            Log.d("TAG", "patchSeaTDataResult: ${value.status}")
        }
    }
}