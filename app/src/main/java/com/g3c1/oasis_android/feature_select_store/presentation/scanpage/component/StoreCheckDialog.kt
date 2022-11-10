package com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.g3c1.oasis_android.ui.theme.Gray9

@Composable
fun StoreCheckDialog(
    visible: Boolean,
    onDismissRequest: () -> Unit,
    okRequest: () -> Unit,
    properties: DialogProperties = DialogProperties(),
    storeName: String,
) {
    if (visible) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = properties
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(0.85f),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.Start
                ) {
                    DefalutText(
                        text = storeName,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    DefalutText(
                        text = "이(가) 맞나요?",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        color = Gray9
                    )
                }
                Spacer(modifier = Modifier.size(30.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(0.9f),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.End
                ) {
                    DialogText(text = "취소") {
                        onDismissRequest()
                    }
                    Spacer(modifier = Modifier.size(10.dp))
                    DialogText(text = "확인") {
                        okRequest()
                    }
                }
                Spacer(modifier = Modifier.size(5.dp))
            }
        }
    }
}