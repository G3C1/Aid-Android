package com.g3c1.oasis_android.feature_menu.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.g3c1.oasis_android.feature_menu.presentation.menu.MenuScreen
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuActivity: ComponentActivity() {

    private val viewModel by viewModels<MenuViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getMenuList()

    }

    private fun getMenuList() {
        lifecycleScope.launch {
            viewModel.getMenuList()
            viewModel.mMenuList.collect {
                when(it) {
                    is ApiState.Success -> {
                        Log.d("TAG", "getMenuList: ${it.data}")
                        setContent { MenuScreen(it.data!!) }
                        viewModel.mMenuList.value = ApiState.Loading()
                    }
                    is ApiState.Error -> {
                        viewModel.mMenuList.value = ApiState.Loading()
                    }
                    is ApiState.Loading -> {}
                }
            }
        }
    }
}