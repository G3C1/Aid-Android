package com.g3c1.oasis_android.feature_chat.presentation

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.g3c1.oasis_android.feature_chat.presentation.example.component.*
import com.g3c1.oasis_android.feature_chat.presentation.util.FireStoreDTO
import com.g3c1.oasis_android.feature_chat.presentation.vm.ChatViewModel
import com.g3c1.oasis_android.feature_menu.presentation.MenuActivity
import com.google.firebase.firestore.FirebaseFirestore

class ChatActivity : ComponentActivity() {

    private val viewModel by viewModels<ChatViewModel>()
    private val db = FirebaseFirestore.getInstance()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe()
        setContent {
            val text = remember {
                mutableStateOf("")
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                TopBar(tableNum = "4")
                ChatList(
                    chatList = viewModel.chatList, isTemi = viewModel.isTemiList
                )
                Column {
                    Row {
                        Menu(onClick = {
                            val data = FireStoreDTO(
                                sentence = "#메뉴판", valid = true
                            )
                            viewModel.chatList.add("#메뉴판")
                            viewModel.isTemiList.add(false)
                            viewModel.chattingManager(db = db, data)
                        })
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
                            val data = FireStoreDTO(
                                sentence = text.value, valid = true
                            )
                            if (text.value != "") {
                                viewModel.chatList.add(text.value)
                                viewModel.isTemiList.add(false)
                                text.value = ""
                            }
                            viewModel.chattingManager(db = db, data)
                        }
                    }
                }
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    }

    private fun observe() {
        viewModel.temiAns.observe(this) {
            if (it == "0") {
                startActivity(Intent(this, MenuActivity::class.java))
            }
        }
    }
}