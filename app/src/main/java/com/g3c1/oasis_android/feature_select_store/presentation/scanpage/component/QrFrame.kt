package com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.g3c1.oasis_android.R

@Composable
fun QrFrame(code: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.size(15.dp))
        Image(
            painterResource(id = R.drawable.qr_frame),
            contentDescription = "QRcodeFrame"
        )
        Spacer(modifier = Modifier.size(15.dp))
        TakeQrPicture(code = code)
    }
}