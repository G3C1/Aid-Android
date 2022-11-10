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
import androidx.compose.ui.graphics.Color
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
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(Color.Yellow)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.fillMaxWidth(0.5f).background(Color.Blue)) {
            Image(
                painter = rememberImagePainter(data = data.img),
                contentDescription = "imageThumbnail",
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.Crop,
            )
            
            Spacer(modifier = Modifier.width(12.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = data.name, fontFamily = Font.pretendard, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "${data.price}원", fontFamily = Font.pretendard, fontSize = 14.sp)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(0.5f).background(Color.Red),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .background(Gray5)
                    .clip(RoundedCornerShape(100.dp))
                    .padding(10.dp, 8.dp, 10.dp, 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = "-", fontSize = 16.sp)
                Spacer(modifier = Modifier.width(11.dp))
                Text(text = "${data.amount}개", fontSize = 13.sp)
                Spacer(modifier = Modifier.width(11.dp))
                Text(text = "+", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.width(31.dp))
            Text(text = "삭제", fontSize = 14.sp, fontFamily = Font.pretendard)
        }
    }
}