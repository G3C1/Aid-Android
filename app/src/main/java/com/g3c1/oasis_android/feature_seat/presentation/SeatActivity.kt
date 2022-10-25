package com.g3c1.oasis_android.feature_seat.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.SeatListScreen
import com.g3c1.oasis_android.feature_seat.presentation.vm.SeatDataViewModel
import com.g3c1.oasis_android.remote.util.ApiState
import com.g3c1.oasis_android.ui.theme.Orange
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SeatActivity : ComponentActivity() {

    private val seatViewModel by viewModels<SeatDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getSeatDataList()
        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                Icon(
                    modifier = Modifier.size(200.dp).align(Alignment.Center),
                    painter = painterResource(id = R.drawable.ic_aid),
                    contentDescription = "logo",
                    tint = Orange,
                )
            }
        }
    }

    private fun getSeatDataList() {
        lifecycleScope.launch {
            seatViewModel.getSeatDataList()
            seatViewModel.mSeatDataList.collect {
                when (it) {
                    is ApiState.Success -> {
                        Log.d("TAG", it.data.toString())
                        seatViewModel.mSeatDataList.value = ApiState.Loading()
                        setContent {
                            SeatListScreen(it.data!!, viewModel = seatViewModel)
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
}