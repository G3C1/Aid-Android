package com.g3c1.oasis_android.feature_chat.presentation.example.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.g3c1.oasis_android.ui.theme.Orange

@Composable
fun Menu(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier.padding(start = 13.dp, end = 13.dp, top = 5.dp, bottom = 5.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Orange,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text = "#메뉴판")
    }
}

@Composable
fun SendBtn(onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
        modifier = Modifier
            .width(50.dp)
            .height(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Orange, contentColor = Color.White
        )
    ) {
        Icon(
            imageVector = Icons.Default.Send,
            contentDescription = "",
            modifier = Modifier
                .rotate(-45f)
                .width(20.dp)
                .height(20.dp)
        )
    }
}