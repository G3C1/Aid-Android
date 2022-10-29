package com.g3c1.oasis_android.feature_menu.presentation.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_menu.data.dto.FoodDTO
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.feature_menu.presentation.shopping_basket.component.ShoppingBasketButton
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import com.g3c1.oasis_android.ui.theme.Font
import kotlinx.coroutines.launch

@Composable
fun FoodDetailScreen(
    navController: NavController,
    viewModel: MenuViewModel,
    menuId: Int?,
    menuList: List<MenuDTO>
) {

    val count = remember { mutableStateOf(1)}
    val allMenuList = mutableListOf<FoodDTO>()
    val scope = rememberCoroutineScope()

    menuList.forEach { category ->
        category.foodList.forEach { menu ->
            allMenuList.add(menu)
        }
    }
    Log.d("TAG", "FoodDetailScreen: $allMenuList")
    Log.d("TAG", menuId.toString())

    val data = allMenuList.first { it.id == menuId }


    val painter = rememberImagePainter(data = data.img, builder = {
        R.drawable.ic_cart
    })

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
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "${data.servings}인분", fontFamily = Font.pretendard, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(290.dp))
                Text(text = "${data.price}원", fontFamily = Font.pretendard, fontSize = 16.sp)
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { if(count.value > 1) count.value = count.value - 1}) {
                    Text(text = "-")
                }
                Text(text = count.value.toString(), textAlign = TextAlign.Center)
                IconButton(onClick = { count.value = count.value + 1 }) {
                    Text(text = "+")
                }
            }
        }

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ShoppingBasketButton (onClick = {
                scope.launch {
                    navController.popBackStack()
                }
            },
            visibility = true,
            count.value * data.price
            )
        }
    }

}