package com.g3c1.oasis_android.feature_menu.presentation.shopping_basket.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.g3c1.oasis_android.feature_menu.data.dto.OrderFoodDTO
import com.g3c1.oasis_android.feature_menu.presentation.vm.MenuViewModel
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Gray5

@OptIn(ExperimentalCoilApi::class)
@Composable
fun OrderedMenuComponent(
    data: OrderFoodDTO,
    viewModel: MenuViewModel
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
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
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Gray5)
                        .padding(10.dp, 0.dp, 10.dp, 0.dp)
                        .width(80.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        onClick = { viewModel.decreaseFoodAmount(data.id) },
                        modifier = Modifier.size(28.dp)
                    ) {
                        Text(
                            text = "-",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Text(text = "${data.amount}개", fontSize = 13.sp)
                    IconButton(
                        onClick = { viewModel.increaseOnlyOneAmount(data.id) },
                        modifier = Modifier.size(28.dp)
                    ) {
                        Text(
                            text = "+",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
                Spacer(modifier = Modifier.width(31.dp))
                Text(text = "삭제", fontSize = 14.sp, fontFamily = Font.pretendard)
            }
        }

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            drawLine(
                start = Offset(x = 0f, 0f),
                end = Offset(x = size.width, y = 0f),
                color = Gray5,
                strokeWidth = 8f
            )
        }
    }
}