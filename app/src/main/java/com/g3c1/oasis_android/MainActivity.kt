package com.g3c1.oasis_android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.SeatListScreen
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.component.SeatSubmitButton
import com.g3c1.oasis_android.feature_seat.presentation.vm.SeatDataViewModel
import com.g3c1.oasis_android.remote.util.ApiState
import com.g3c1.oasis_android.ui.theme.OasisAndroidTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity: ComponentActivity() {

    private val seatViewModel by viewModels<SeatDataViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize()
            ) {
                SeatListScreen()
            }
        }
//        getSeatDataList()
    }
    private fun getSeatDataList() {
        lifecycleScope.launch {
            seatViewModel.getSeatDataList()
            seatViewModel.mSeatDataList.collect{
                when(it){
                   is ApiState.Success -> {
                       Log.d("TAG", it.data.toString())
                       seatViewModel.mSeatDataList.value = ApiState.Loading()
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