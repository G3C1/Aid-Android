package com.g3c1.oasis_android.feature_select_store.presentation.scanpage

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component.AnimatiedStoreSelectButton
import com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component.AnimatiedTopStoreInfoBar
import com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component.QrScanScreen
import com.g3c1.oasis_android.feature_select_store.presentation.util.QrCodeAnalyer

class QrScanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var code by remember {
                mutableStateOf("")
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                QrScanScreen(code = code, analyer = QrCodeAnalyer {
                    code = it
                })
                AnimatiedStoreSelectButton(visible = code != "") {
                    Log.d("onClick", "눌렸다!")
                }
                AnimatiedTopStoreInfoBar(
                    visible = code != "",
                    storeName = "노혁 김밥집",
                    storeIntroduce = "개 노맛",
                    storeLogoUrl = ""
                )
            }
        }
    }
}