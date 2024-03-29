package com.g3c1.oasis_android.feature_menu.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_menu.data.dto.FoodDTO
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.feature_menu.presentation.menu.component.TopBar
import com.g3c1.oasis_android.feature_menu.presentation.shopping_basket.component.ShoppingBasketButton
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.LightGray
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterialApi::class)
@Composable
fun FoodDetailScreen(
    navController: NavController,
    viewModel: MenuViewModel,
    menuId: Int?,
    menuList: List<MenuDTO>,
    bottomSheetScaffoldState: BottomSheetScaffoldState
) {

    val count = remember { mutableStateOf(1) }
    val allMenuList = mutableListOf<FoodDTO>()
    val scope = rememberCoroutineScope()

    menuList.forEach { category ->
        category.foodList.forEach { menu ->
            allMenuList.add(menu)
        }
    }
    val data = allMenuList.first { it.id == menuId }

    val painter = rememberImagePainter(data = data.img, builder = {
        R.drawable.ic_cart
    })

    TopBar(
        clickBackButton = { navController.popBackStack() },
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

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(8.dp))
        Image(
            modifier = Modifier
                .height(height = 250.dp)
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
                .clip(RoundedCornerShape(10f)),
            painter = painter,
            contentDescription = "food preview",
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 8.dp)
        ) {
            Text(
                text = data.name,
                fontFamily = Font.pretendard,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = data.description,
                fontFamily = Font.pretendard,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(
                    text = "${data.servings}인분",
                    fontFamily = Font.pretendard,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(
                        Alignment.CenterStart
                    )
                )
                Text(
                    text = "${data.price}원",
                    fontFamily = Font.pretendard,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(
                        Alignment.CenterEnd
                    )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(LightGray)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(
                    text = "수량",
                    fontFamily = Font.pretendard,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(
                        Alignment.CenterStart
                    )
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clip(RoundedCornerShape(18.dp))
                        .background(LightGray)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.minus_btn_ic),
                            contentDescription = "minus btn icon",
                            modifier = Modifier
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = rememberRipple(
                                        radius = 10.dp
                                    )
                                ) { if (count.value > 1) count.value = count.value - 1 }
                                .padding(10.dp)
                        )
                        Text(
                            text = "${count.value}개",
                            textAlign = TextAlign.Center,
                            fontFamily = Font.pretendard,
                            fontWeight = FontWeight.Medium
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.plus_btn_ic),
                            contentDescription = "plus btn icon",
                            modifier = Modifier
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = rememberRipple(
                                        radius = 10.dp
                                    )
                                ) { count.value = count.value + 1 }
                                .padding(10.dp)
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(LightGray)
            )
        }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ShoppingBasketButton(
                onClick = {
                    scope.launch {
                        viewModel.checkIfFoodIsOnTheList(itemId = menuId!!, amount = count.value)
                        navController.popBackStack()
                    }
                },
                visibility = true,
                count.value * data.price
            )
        }
    }

}