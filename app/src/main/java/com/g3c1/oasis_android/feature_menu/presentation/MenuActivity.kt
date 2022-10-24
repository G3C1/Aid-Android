package com.g3c1.oasis_android.feature_menu.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.g3c1.oasis_android.feature_menu.presentation.menu.MenuScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState, )
        setContent {
            MenuScreen()
        }
    }
}