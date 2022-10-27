package com.g3c1.oasis_android.feature_chat.presentation

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.g3c1.oasis_android.feature_chat.presentation.example.component.ChatList
import com.g3c1.oasis_android.feature_chat.presentation.example.component.ChatTextField
import com.g3c1.oasis_android.feature_chat.presentation.example.component.Menu
import com.g3c1.oasis_android.feature_chat.presentation.example.component.SendBtn
import com.g3c1.oasis_android.feature_chat.presentation.util.Utils.assetFilePath
import com.g3c1.oasis_android.feature_chat.presentation.vm.ChatViewModel
import org.pytorch.LiteModuleLoader
import org.pytorch.Module
import java.io.IOException

class ChatActivity : ComponentActivity() {

    private val viewModel by viewModels<ChatViewModel>()
    private var chatBotModel: Module? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            chatBotModel = LiteModuleLoader.load(assetFilePath(this, "chatbot_model.ptl"))
        } catch (e: IOException) {
            Log.e("TAG", "Unable to load model", e)
        }

        setContent {
            val text = remember {
                mutableStateOf("")
            }
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                ChatList(
                    chatList = viewModel.chatList,
                    isTemi = viewModel.isTemiList
                )
                Column {
                    Row {
                        Menu(onClick = {})
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        Arrangement.Center,
                        Alignment.CenterVertically
                    ) {
                        ChatTextField(text = text.value) {
                            text.value = it
                        }
                        Spacer(Modifier.size(10.dp))
                        SendBtn {
                            if (text.value != "") {
                                viewModel.chatList.add(text.value)
                                viewModel.isTemiList.add(false)
                                text.value = ""
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }
}