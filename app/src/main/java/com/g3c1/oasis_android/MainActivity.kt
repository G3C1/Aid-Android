package com.g3c1.oasis_android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.lifecycleScope
import com.g3c1.oasis_android.feature_chat.presentation.ChatActivity
import com.g3c1.oasis_android.ui.theme.Orange
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(Orange)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Orange),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(painterResource(id = R.drawable.aide_logo), contentDescription = "AideLogo")
            }
            goSelectStore()
        }
    }

    private fun goSelectStore() {
        lifecycleScope.launch {
            delay(1500)
            startActivity(Intent(this@MainActivity, ChatActivity::class.java))
        }
    }
}