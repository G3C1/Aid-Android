package com.g3c1.oasis_android.feature_chat.presentation.example.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatList(chatList: List<String>, isTemi: List<Boolean>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f)
    ) {
        items(chatList.size) {
            if (isTemi[it])
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                ) {
                    TemiText(text = chatList[it])
                }
            else
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    ChatText(text = chatList[it])
                }
        }
    }
}