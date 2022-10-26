package com.g3c1.oasis_android.feature_menu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.g3c1.oasis_android.feature_menu.presentation.menu.MenuScreen
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity: ComponentActivity() {

    private val viewModel by viewModels<MenuViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState, )
        setContent {
            MenuScreen()
        }
    }
}