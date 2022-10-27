package com.g3c1.oasis_android.feature_menu.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.feature_menu.domain.use_case.GetMenuListUseCase
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val getMenuListUseCase: GetMenuListUseCase
) : ViewModel() {

    val mMenuList: MutableStateFlow<ApiState<List<MenuDTO>>> = MutableStateFlow(ApiState.Loading())

    fun getMenuList() = viewModelScope.launch {
        mMenuList.value = ApiState.Loading()
        getMenuListUseCase.getMenuListUseCase().catch { error ->
            mMenuList.value = ApiState.Error("${error.message}")
        }.collect { value ->
            mMenuList.value = value
        }
    }
}