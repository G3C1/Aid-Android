package com.g3c1.oasis_android.feature_menu.presentation.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
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
import coil.compose.rememberImagePainter
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.feature_menu.presentation.menu.component.ThumbNail
import com.g3c1.oasis_android.feature_menu.presentation.menu.component.TopBar
import com.g3c1.oasis_android.ui.theme.*

@Composable
fun MenuScreen(seatDataList: List<MenuDTO>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar(text = "메뉴판")
        val selectedValue = remember { mutableStateOf<Int?>(1) }
        val isSelectedItem: (Int) -> Boolean = { selectedValue.value == it }
        val painter = rememberImagePainter(
            data = "https://avatars.githubusercontent.com/u/82383983?v=4",
            builder = {
                placeholder(R.drawable.ic_cart)
            })
        val onChangeState: (Int) -> Unit = {
            selectedValue.value = it
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(start = 8.dp)
        ) {
            items(seatDataList.size) { index ->

                val color = if (isSelectedItem(seatDataList[index].id)) Orange else Gray
                val textColor =
                    if (isSelectedItem(seatDataList[index].id)) Color.White else Gray2
                Row(
                    Modifier
                        .height(40.dp)
                        .selectable(
                            selected = isSelectedItem(seatDataList[index].id),
                            onClick = { onChangeState(seatDataList[index].id); },
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
                        text = seatDataList[index].category,
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
            ),
        ) {
            items(seatDataList[selectedValue.value!! - 1].foodList.size) { index ->
                Spacer(modifier = Modifier.height(16.dp))
                Row (modifier = Modifier.clickable {

                }){
                    ThumbNail(painter = painter)
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = seatDataList[selectedValue.value!! - 1].foodList[index].name,
                            fontSize = 16.sp,
                            fontFamily = Font.pretendard,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${seatDataList[selectedValue.value!! - 1].foodList[index].servings}인분 : ${seatDataList[selectedValue.value!! - 1].foodList[index].price}원",
                            fontFamily = Font.pretendard,
                            fontSize = 14.sp
                        )
                        Text(
                            text = seatDataList[selectedValue.value!! - 1].foodList[index].description,
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
}