package com.g3c1.oasis_android.feature_receipt.presentation.receipt.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import com.g3c1.oasis_android.ui.theme.LightGray

@Composable
fun HorizontalDivider(height: Float) {
    Canvas(modifier = Modifier
        .fillMaxWidth()) {

        // setting start x and end y
        val canvasWidth = size.width

        // drawing a line between start(x,y) and end(x,y)
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = 0f),
            color = LightGray,
            strokeWidth = height
        )
    }
}