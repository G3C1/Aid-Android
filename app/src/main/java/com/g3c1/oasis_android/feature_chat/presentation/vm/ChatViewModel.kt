package com.g3c1.oasis_android.feature_chat.presentation.vm

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.g3c1.oasis_android.feature_chat.presentation.util.FireStoreDTO
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatViewModel @Inject constructor(

) : ViewModel() {
    private val TAG = "ChatViewModel"

    private val _chatList = mutableStateListOf("안녕하세요 저는 ai 챗봇 AiD에요. 저에게 가게에 대해 궁금하신거를 문의하면 답변해드려요.")
    val chatList: MutableList<String> get() = _chatList

    private val _isTemiList = mutableStateListOf(true)
    val isTemiList: MutableList<Boolean> get() = _isTemiList

    private val _temiAns = MutableLiveData<String>()
    val temiAns: LiveData<String> get() = _temiAns

    private var isFirst = true

    fun chattingManager(db: FirebaseFirestore, data: FireStoreDTO) {
        db.collection("android").document("chat").set(data)

        viewModelScope.launch {
            delay(1500)
            isFirst = true
            db.collection("result").document("model").get()
                .addOnSuccessListener { result ->
                    data.valid = false
                    Log.d(TAG, result.get("res").toString())
                    temiChatManager(result.get("res").toString())
                    db.collection("android").document("chat").set(data)
                }
                .addOnFailureListener {
                    Log.e(TAG, "error : $it")
                }
        }
    }

    private fun temiChatManager(answer: String) {
        when (answer) {
            "0" -> {
                _chatList.add("메뉴 페이지로 이동할게요!")
                _isTemiList.add(true)
            }
            "1" -> {
                _chatList.add("화장실은 000에 있어요!")
                _isTemiList.add(true)
            }
            "2" -> {
                _chatList.add("직원을 호출 할게요!")
                _isTemiList.add(true)
            }
            else -> {
                _chatList.add("잘 알아듣지 못했어요!")
                _isTemiList.add(true)
            }
        }
        _temiAns.value = answer
    }
}