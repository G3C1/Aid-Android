package com.g3c1.oasis_android.feature_menu.presentation.shopping_basket.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.g3c1.oasis_android.feature_menu.data.dto.OrderFoodDTO
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Gray5

@OptIn(ExperimentalCoilApi::class)
@Composable
fun OrderedMenuComponent(data: OrderFoodDTO) {

    val amount = remember { mutableStateOf(1) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.fillMaxWidth(0.5f)){
            Image(
                painter = rememberImagePainter(data = data.img),
                contentDescription = "imageThumbnail",
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop,
            )

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = data.name, fontFamily = Font.pretendard, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "${data.price}원", fontFamily = Font.pretendard, fontSize = 14.sp)
            }
        }

        Row (modifier = Modifier.fillMaxWidth(0.5f)){
            Text(text = "삭제", fontSize = 14.sp, fontFamily = Font.pretendard)
            Spacer(modifier = Modifier.width(31.dp))
            Row(
                modifier = Modifier
                    .background(Gray5)
                    .clip(RoundedCornerShape(9999f))
                    .padding(10.dp, 8.dp, 10.dp, 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                ) {
                Text(text = "-", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(11.dp))
                Text(text = "${amount}개", fontSize = 13.sp)
                Spacer(modifier = Modifier.width(11.dp))
                Text(text = "+", fontSize = 16.sp)
            }
        }
    }
}