package com.g3c1.oasis_android.feature_select_store.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.g3c1.oasis_android.feature_select_store.data.dto.SummarizedStoreInfoDTO
import com.g3c1.oasis_android.feature_select_store.domain.usecase.GetSumarizedStoreInfoUseCase
import com.g3c1.oasis_android.remote.util.ApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

class SelectStoreViewModel @Inject constructor(
    private val getSumarizedStoreInfoUseCase: GetSumarizedStoreInfoUseCase
) : ViewModel() {
    val mStoreData: MutableStateFlow<ApiState<SummarizedStoreInfoDTO>> =
        MutableStateFlow(ApiState.Loading())

    fun getSumarizedStoreInfo(searialNumber: Int) = viewModelScope.launch {
        mStoreData.value = ApiState.Loading()
        getSumarizedStoreInfoUseCase.getSumarizedStoreInfo(searialNumber = searialNumber)
            .catch { error ->
                mStoreData.value = ApiState.Error("${error.message}")
            }.collect { value ->
                mStoreData.value = value
            }
    }
}