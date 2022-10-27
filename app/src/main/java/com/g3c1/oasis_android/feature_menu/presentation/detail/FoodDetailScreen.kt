package com.g3c1.oasis_android.feature_menu.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_menu.data.dto.FoodDTO
import com.g3c1.oasis_android.feature_menu.presentation.menu.component.TopBar
import com.g3c1.oasis_android.ui.theme.Font

@Composable
fun FoodDetailScreen(data: FoodDTO) {

    val painter = rememberImagePainter(data = data.img, builder = {
        R.drawable.ic_cart
    })

    Column(modifier = Modifier.fillMaxSize()) {
        TopBar(text = "", clickShoppingBasketButton = {}, clickBackButton = {})
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
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 8.dp)) {
            Text(text = data.name, fontFamily = Font.pretendard, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = data.description, fontFamily = Font.pretendard, fontWeight = FontWeight.Normal, fontSize = 14.sp)
        }
    }

}