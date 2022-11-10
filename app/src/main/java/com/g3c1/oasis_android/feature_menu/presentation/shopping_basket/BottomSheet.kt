package com.g3c1.oasis_android.feature_menu.presentation.shopping_basket

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_menu.presentation.menu.component.TopBar
import com.g3c1.oasis_android.feature_menu.presentation.menu.navigation.MenuNavigation
import com.g3c1.oasis_android.feature_menu.presentation.shopping_basket.component.OrderedMenuComponent
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import com.g3c1.oasis_android.ui.theme.Font
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
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp),
        sheetContent = {
            val orderMenuList = remember { viewModel.orderMenuList }
            Log.d("TAG", "BottomSheet: orderMenuList = $orderMenuList")
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
                        .height(72.dp),
                ) {
                    items(orderMenuList.size) {
                        OrderedMenuComponent(
                            data = orderMenuList[it],
                            viewModel = viewModel
                        )
                    }
                }
            }
        },
        sheetPeekHeight = 0.dp
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopBar(
                clickBackButton = {},
                clickShoppingBasketButton = {
                    scope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                },
                text = "메뉴판"
            )
            Spacer(modifier = Modifier.height(20.dp))
            MenuNavigation(viewModel = viewModel, menuDataList = list)
        }
    }

}