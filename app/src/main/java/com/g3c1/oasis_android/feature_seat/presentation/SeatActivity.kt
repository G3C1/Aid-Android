package com.g3c1.oasis_android.feature_seat.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.SeatListScreen
import com.g3c1.oasis_android.feature_seat.presentation.vm.SeatDataViewModel
import com.g3c1.oasis_android.remote.util.ApiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SeatActivity: ComponentActivity() {

    private val seatViewModel by viewModels<SeatDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getSeatDataList()
        setContent {

        }
    }
    private fun getSeatDataList() {
        lifecycleScope.launch {
            seatViewModel.getSeatDataList()
            seatViewModel.mSeatDataList.collect{
                when(it){
                    is ApiState.Success -> {
                        Log.d("TAG", it.data.toString())
                        seatViewModel.mSeatDataList.value = ApiState.Loading()
                        setContent {
                            SeatListScreen(it.data!! ,viewModel = seatViewModel)
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