package com.g3c1.oasis_android.feature_receipt.presentation.receipt.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderedMenuInfo
import com.g3c1.oasis_android.ui.theme.Font

@Composable
fun OrderItems(item: RemoteOrderedMenuInfo) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.align(Alignment.CenterStart)) {
            Image(
                painter = rememberImagePainter(
                    data = item.foodImg,
                    builder = {
                        placeholder(R.drawable.ic_aid)
                    }
                ),
                contentDescription = "MenuThumb",
                modifier = Modifier
                    .size(60.dp)
                    .clip(shape = RoundedCornerShape(30f))
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = item.foodName,
                    fontFamily = Font.pretendard,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
                Text(
                    text = "${item.price}원",
                    fontFamily = Font.pretendard,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start,
                    fontSize = 15.sp
                )
            }
        }

        Text(
            text = "${item.servings * item.foodCount}인분",
            textAlign = TextAlign.Center,
            fontFamily = Font.pretendard,
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 20.dp)
        )

    }
}