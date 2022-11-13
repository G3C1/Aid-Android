package com.g3c1.oasis_android.feature_select_store.presentation.scanpage

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component.AnimatiedStoreSelectButton
import com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component.AnimatiedTopStoreInfoBar
import com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component.QrScanScreen
import com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component.StoreCheckDialog
import com.g3c1.oasis_android.feature_select_store.presentation.util.QrCodeAnalyer
import com.g3c1.oasis_android.feature_select_store.presentation.vm.SelectStoreViewModel
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class StoreSelectActivity : ComponentActivity() {

    private val storeSelectViewModel by viewModels<SelectStoreViewModel>()
    private var apiSuccess = mutableStateOf(false)
    private var storeName = mutableStateOf("")
    private var storeImg = mutableStateOf("")
    private var storeDescription = mutableStateOf("")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var code by remember { mutableStateOf("") }
            var visible by remember { mutableStateOf(false) }
            if (code != "") {
                storeSelectViewModel.setSearialNumber(code.toInt())
                getSumarizedStoreInfo()
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                QrScanScreen(analyer = QrCodeAnalyer {
                    code = it
                })
                AnimatiedStoreSelectButton(visible = apiSuccess.value) {
                    visible = true
                }
                StoreCheckDialog(
                    visible = visible,
                    { visible = false },
                    storeName = storeName.value,
                    okRequest = { })
                AnimatiedTopStoreInfoBar(
                    visible = apiSuccess.value,
                    storeName = storeName.value,
                    storeIntroduce = storeDescription.value,
                    storeLogoUrl = storeImg.value
                )
            }
        }
    }

    private fun getSumarizedStoreInfo() {
        lifecycleScope.launch {
            storeSelectViewModel.getSumarizedStoreInfo()
            storeSelectViewModel.mStoreData.collect {
                when (it) {
                    is ApiState.Success -> {
                        apiSuccess.value = true
                        storeName.value = it.data!!.name
                        storeImg.value = it.data.img
                        storeDescription.value = it.data.description
                    }
                    is ApiState.Error -> {
                        Log.e("StoreAPI - error", it.message.toString())
                        storeSelectViewModel.mStoreData.value = ApiState.Loading()
                    }
                    is ApiState.Loading -> {}
                }
            }
        }
    }
}