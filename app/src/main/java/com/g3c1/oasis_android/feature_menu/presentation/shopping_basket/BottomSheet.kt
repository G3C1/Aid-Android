package com.g3c1.oasis_android.feature_menu.presentation.shopping_basket

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.di.OasisApp
import com.g3c1.oasis_android.feature_menu.data.dto.OrderInfoDTO
import com.g3c1.oasis_android.feature_menu.data.dto.OrderedTableInfoDTO
import com.g3c1.oasis_android.feature_menu.presentation.menu.navigation.MenuNavigation
import com.g3c1.oasis_android.feature_menu.presentation.shopping_basket.component.OrderButton
import com.g3c1.oasis_android.feature_menu.presentation.shopping_basket.component.OrderedMenuComponent
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Gray5
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(viewModel: MenuViewModel) {
    val scope = rememberCoroutineScope()
    val sheetState =
        rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val list = remember { viewModel.menuList }
    val orderMenuList = remember { viewModel.orderMenuList }


    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),
        sheetContent = {
            Log.d("TAG", "BottomSheet: orderMenuList = $orderMenuList")
            Box(modifier = Modifier.fillMaxSize()) {
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
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        items(orderMenuList.size) {
                            OrderedMenuComponent(
                                data = orderMenuList[it],
                                viewModel = viewModel
                            )
                        }
                    }
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        drawRect(
                            color = Gray5,
                            size = size
                        )
                    }
                }
                OrderButton(
                    price = viewModel.orderMenuList.sumOf { it.amount * it.price },
                    visibility = viewModel.orderMenuList.isNotEmpty(),
                    onClick = {
                        scope.launch {
                            viewModel.sendsTheOrderedFoodList(body = OrderedTableInfoDTO(
                                serialNumber = OasisApp.getInstance()
                                    .getSearialNumberManager().searialNumber.first().toLong(),
                                seatId = OasisApp.getInstance().getDataStore().text.first()
                                    .toLong(),
                                foodList = viewModel.orderMenuList.map {
                                    OrderInfoDTO(
                                        foodId = it.id,
                                        foodCount = it.amount
                                    )
                                }
                            ))
                        }
                    },
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }

        },
        sheetPeekHeight = 0.dp
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            MenuNavigation(viewModel = viewModel, menuDataList = list, bottomSheetScaffoldState = bottomSheetScaffoldState)
        }
    }

}