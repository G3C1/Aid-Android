package com.g3c1.oasis_android.feature_chat.presentation.vm

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class ChatViewModel @Inject constructor(

) : ViewModel() {
    private val _chatList = mutableListOf("챗봇에게 무엇이던 질문해보세요!")
    val chatList: MutableList<String> get() = _chatList

    private val _isTemiList = mutableListOf(true)
    val isTemiList: MutableList<Boolean> get() = _isTemiList
}