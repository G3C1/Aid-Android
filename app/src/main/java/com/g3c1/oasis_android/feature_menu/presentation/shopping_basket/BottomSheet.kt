package com.g3c1.oasis_android.feature_menu.presentation.shopping_basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.feature_menu.presentation.menu.component.TopBar
import com.g3c1.oasis_android.feature_menu.presentation.menu.navigation.MenuNavigation
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import com.g3c1.oasis_android.ui.theme.Font
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheet(viewModel: MenuViewModel, list: List<MenuDTO>) {
    val scope = rememberCoroutineScope()
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
                    } },
                text = "메뉴판"
            )
            MenuNavigation(viewModel = viewModel, menuDataList = list)
        }
    }
}