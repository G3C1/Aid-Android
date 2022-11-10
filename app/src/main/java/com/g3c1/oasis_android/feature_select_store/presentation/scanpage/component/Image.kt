package com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.g3c1.oasis_android.R

@Composable
fun QrImageFrame() {
    Image(
        painterResource(id = R.drawable.qr_frame),
        contentDescription = "QRcodeFrame"
    )
}

@Composable
fun StoreLogo(url: String) {
    Image(
        painterResource(id = R.drawable.aide),
        contentDescription = "StoreLogo",
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .fillMaxWidth(0.2f)
    )
}