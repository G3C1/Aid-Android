package com.g3c1.oasis_android.feature_chat.presentation.example.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatList(chatList: List<String>, isTemi: List<Boolean>) {

    val listState = rememberLazyListState()
    val corutineScope = rememberCoroutineScope()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.8f),
        state = listState
    ) {
        corutineScope.launch {
            listState.animateScrollToItem(chatList.size - 1)
        }
        items(chatList.size) {
            if (isTemi[it]) Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
            ) {
                TemiText(text = chatList[it])
            }
            else Row(
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