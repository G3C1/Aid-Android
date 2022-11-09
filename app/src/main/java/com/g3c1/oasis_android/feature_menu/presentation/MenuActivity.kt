package com.g3c1.oasis_android.feature_menu.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.g3c1.oasis_android.feature_menu.presentation.shopping_basket.BottomSheet
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuActivity : ComponentActivity() {

    private val menuViewModel by viewModels<MenuViewModel>()

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMenuList()
        setContent {
            BottomSheet(
                viewModel = viewModel(LocalContext.current as MenuActivity),
            )
        }
    }

    private fun getMenuList() {
        lifecycleScope.launch {
            menuViewModel.getMenuList()
            menuViewModel.mMenuList.collect { data ->
                when (data) {
                    is ApiState.Success -> {
                        Log.d("TAG", data.data.toString())
                        menuViewModel.insertAllMenuListItems(data.data!!)
                        menuViewModel.mMenuList.value = ApiState.Loading()
                        menuViewModel.saveTheReceivedMenuList(data.data)
                    }
                    is ApiState.Error -> {
                        Log.e("TAG", data.message.toString())
                        menuViewModel.mMenuList.value = ApiState.Loading()
                    }
                    is ApiState.Loading -> {}
                }
            }
        }
    }
}