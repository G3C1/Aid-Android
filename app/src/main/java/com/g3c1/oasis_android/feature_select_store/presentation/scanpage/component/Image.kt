package com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.rememberImagePainter
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
        modifier = Modifier
            .fillMaxHeight(0.8f)
            .fillMaxWidth(0.25f)
            .clip(RoundedCornerShape(10)),
        contentScale = ContentScale.Crop,
        painter = rememberImagePainter(url),
        contentDescription = "StoreLogo"
    )
}