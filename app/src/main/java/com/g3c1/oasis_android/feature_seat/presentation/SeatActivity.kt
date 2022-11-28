package com.g3c1.oasis_android.feature_seat.presentation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_chat.presentation.ChatActivity
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.SeatListScreen
import com.g3c1.oasis_android.feature_seat.presentation.vm.SeatDataViewModel
import com.g3c1.oasis_android.remote.util.ApiState
import com.g3c1.oasis_android.ui.theme.Orange
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SeatActivity : ComponentActivity() {

    private val seatViewModel by viewModels<SeatDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getSeatDataList()
        observeState()
        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                Icon(
                    modifier = Modifier
                        .size(200.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_aid),
                    contentDescription = "logo",
                    tint = Orange,
                )
            }
        }
    }

    private fun observeState() {
        patchSeatData()
    }

    private fun getSeatDataList() {
        lifecycleScope.launch {
            seatViewModel.getSeatDataList()
            seatViewModel.mSeatDataList.collect { it ->
                when (it) {
                    is ApiState.Success -> {
                        Log.d("TAG", it.data.toString())
                        seatViewModel.mSeatDataList.value = ApiState.Loading()
                        seatViewModel.list = it.data!!.map { it.seatId }
                        setContent {
                            SeatListScreen(
                                it.data,
                                viewModel = viewModel(LocalContext.current as SeatActivity),
                                scope = rememberCoroutineScope(),
                                onSuccess = { successSeatRequest() }
                            )
                        }
                    }
                    is ApiState.Error -> {
                        Log.e("TAG", it.message.toString())
                        seatViewModel.mSeatDataList.value = ApiState.Loading()
                    }
                    is ApiState.Loading -> {}
                }
            }
        }
    }

    private fun patchSeatData() {
        lifecycleScope.launch {
            seatViewModel.mPatchSeatDataResult.collect { response ->
                when (response) {
                    is ApiState.Success -> {
                        successSeatRequest()
                    }
                    is ApiState.Error -> {
                        Log.e("TAGSeatActivity", "SeatActivity: ${response.message.toString()}, ${response.status}")
                        seatViewModel.mPatchSeatDataResult.value = ApiState.Loading()
                    }
                    is ApiState.Loading -> {}
                }
            }
        }
    }

    private fun successSeatRequest() {
        Toast.makeText(this, "자리 선택이 완료되었습니다.", Toast.LENGTH_SHORT).show()
        seatViewModel.mPatchSeatDataResult.value = ApiState.Loading()
        val intent = Intent(this@SeatActivity, ChatActivity::class.java)
        intent.putExtra("seat", seatViewModel.list.indexOf((seatViewModel.selectedSeatId.value.toInt()) + 1).toString())
        startActivity(intent)
        finish()
    }
}