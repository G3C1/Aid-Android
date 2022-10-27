package com.g3c1.oasis_android.feature_menu.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import coil.compose.rememberImagePainter
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_chat.presentation.example.component.Menu
import com.g3c1.oasis_android.feature_menu.presentation.menu.MenuScreen
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.SeatListScreen
import com.g3c1.oasis_android.remote.util.ApiState
import com.g3c1.oasis_android.ui.theme.Font
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuActivity : ComponentActivity() {

    private val menuViewModel by viewModels<MenuViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getMenuList()
    }

    @OptIn(ExperimentalMaterialApi::class)
    private fun getMenuList() {
        lifecycleScope.launch {
            menuViewModel.getMenuList()
            menuViewModel.mMenuList.collect { data ->
                when (data) {
                    is ApiState.Success -> {
                        Log.d("TAG", data.data.toString())
                        menuViewModel.mMenuList.value = ApiState.Loading()
                        setContent {
                            val sheetState =
                                rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
                            val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
                                bottomSheetState = sheetState
                            )
                            BottomSheetScaffold(
                                scaffoldState = bottomSheetScaffoldState,
                                sheetShape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),
                                sheetContent = {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Spacer(modifier = Modifier.height(30.dp))
                                        Image(
                                            painter = painterResource(id = R.drawable.receipt),
                                            contentDescription = "receipt image",
                                            modifier = Modifier
                                                .width(100.dp)
                                                .height(90.dp)
                                        )
                                        Text(
                                            text = "선택하신 메뉴들이에요.",
                                            fontFamily = Font.pretendard,
                                            fontSize = 20.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Spacer(modifier = Modifier.height(66.dp))
                                        LazyRow(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(72.dp),
                                        ) {
                                        }
                                    }
                                },
                                sheetPeekHeight = 0.dp
                            ) {
                                MenuScreen(
                                    data.data!!,
                                    viewModel = menuViewModel,
                                    scope = rememberCoroutineScope(),
                                    bottomSheetScaffoldState
                                )
                            }
                        }
                    }
                    is ApiState.Error -> {
                        Log.e("TAG", data.message.toString())
                        menuViewModel.mMenuList.value = ApiState.Loading()
                    }
                    is ApiState.Loading -> {}
                }
            }
        }
    }
}