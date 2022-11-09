package com.g3c1.oasis_android.feature_menu.presentation.menu

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
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
import com.g3c1.oasis_android.feature_menu.presentation.menu.component.ThumbNail
import com.g3c1.oasis_android.feature_menu.presentation.menu.navigation.Screen
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import com.g3c1.oasis_android.ui.theme.*


@OptIn(ExperimentalCoilApi::class)
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MenuScreen(
    navController: NavController,
    viewModel: MenuViewModel,
    menuDataList: List<MenuDTO>
) {
    val allMenuList = mutableListOf<FoodDTO>()
    Log.d("TAG", "MenuScreen: ${viewModel.mMenuList.value.data}")
    Log.d("TAG", "orderMenuList - MenuActivity: ${viewModel.orderMenuList}")

    menuDataList.forEach { category ->
        category.foodList.forEach { menu ->
            allMenuList.add(menu)
        }
    }

    val afterMenuList = listOf(MenuDTO(id = 0, category = "전체", allMenuList)) + menuDataList

    val menuList = remember { mutableStateOf<List<FoodDTO>>(allMenuList) }

    val selectedValue = remember { mutableStateOf<Int?>(0) }
    val isSelectedItem: (Int) -> Boolean = { selectedValue.value == it }

    val onChangeState: (Int) -> Unit = {
        selectedValue.value = it
        menuList.value =
            afterMenuList.first { item -> item.id == selectedValue.value!! }.foodList.toMutableList()
    }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(start = 8.dp)
    ) {
        items(afterMenuList.size) { index ->

            val color = if (isSelectedItem(afterMenuList[index].id)) Orange else Gray
            val textColor =
                if (isSelectedItem(afterMenuList[index].id)) Color.White else Gray2
            Row(
                Modifier
                    .height(40.dp)
                    .selectable(
                        selected = isSelectedItem(afterMenuList[index].id),
                        onClick = { onChangeState(afterMenuList[index].id) },
                        role = Role.RadioButton,
                    )
                    .padding(0.dp, 6.dp, 0.dp, 6.dp)
                    .clip(
                        shape = RoundedCornerShape(99999f),
                    )
                    .background(color),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start

            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = afterMenuList[index].category,
                    color = textColor,
                    fontSize = 13.sp,
                    fontFamily = Font.pretendard,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
    LazyColumn(
        modifier = Modifier.padding(
            start = 8.dp,
            end = 8.dp,
            top = 16.dp,
            bottom = 16.dp
        )
    ) {
        items(menuList.value.size) { index ->

            val itemList = menuList.value[index]

            val painter = rememberImagePainter(
                data = itemList.img,
                builder = {
                    placeholder(R.drawable.ic_cart)
                })

            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.clickable {
                Log.d("TAG", "MenuScreen_: ${itemList.id}")
                navController.navigate(Screen.DetailScreen.withArgs(itemList.id.toString()))
            }) {
                ThumbNail(painter = painter)
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = itemList.name,
                        fontSize = 16.sp,
                        fontFamily = Font.pretendard,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${itemList.servings}인분 : ${itemList.price}원",
                        fontFamily = Font.pretendard,
                        fontSize = 14.sp
                    )
                    Text(
                        text = itemList.description,
                        fontFamily = Font.pretendard,
                        color = DarkGray
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Gray)
            )
        }
    }
}
