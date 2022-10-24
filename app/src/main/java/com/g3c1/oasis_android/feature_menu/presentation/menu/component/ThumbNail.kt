package com.g3c1.oasis_android.feature_menu.presentation.menu.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun ThumbNail(painter: Painter) {
    Image(
        modifier = Modifier.size(86.dp).clip(shape = RoundedCornerShape(30f)),
        painter = painter,
        contentDescription = "thumbNail",
        alignment = Alignment.CenterStart
    )
}