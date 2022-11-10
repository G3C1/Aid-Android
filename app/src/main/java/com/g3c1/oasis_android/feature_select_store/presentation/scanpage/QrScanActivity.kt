package com.g3c1.oasis_android.feature_select_store.presentation.scanpage

import android.os.Bundle
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
import com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component.StoreCheckDialog
import com.g3c1.oasis_android.feature_select_store.presentation.util.QrCodeAnalyer

class QrScanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var code by remember {
                mutableStateOf("")
            }
            var visible by remember {
                mutableStateOf(false)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                QrScanScreen(analyer = QrCodeAnalyer {
                    code = it
                })
                AnimatiedStoreSelectButton(visible = code != "") {
                    visible = true
                }
                StoreCheckDialog(
                    visible = visible,
                    { visible = false },
                    storeName = "노혁 김밥집",
                    okRequest = { })
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