package com.g3c1.oasis_android.feature_menu.presentation.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.feature_menu.data.dto.MenuDTO
import com.g3c1.oasis_android.feature_menu.presentation.menu.component.TopBar
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Gray
import com.g3c1.oasis_android.ui.theme.Gray2
import com.g3c1.oasis_android.ui.theme.Orange

@Preview
@Composable
fun MenuScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBar()
        val selectedValue = remember { mutableStateOf<Int?>(1) }
        val isSelectedItem: (Int) -> Boolean = { selectedValue.value == it }
        val onChangeState: (Int) -> Unit = { selectedValue.value = it }
        val seatDataList = listOf(
            MenuDTO(id = 1, category = "치킨", foodList = listOf()),
            MenuDTO(id = 2, category = "라면", foodList = listOf()),
            MenuDTO(id = 3, category = "떡볶이", foodList = listOf()),
            MenuDTO(id = 4, category = "삼겹살", foodList = listOf()),
            MenuDTO(id = 5, category = "피자", foodList = listOf()),
            MenuDTO(id = 6, category = "피자", foodList = listOf()),
            MenuDTO(id = 7, category = "피자", foodList = listOf())
        )
        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            items(seatDataList.size) { index ->

                val color = if (isSelectedItem(seatDataList[index].id)) Orange else Gray
                val textColor = if (isSelectedItem(seatDataList[index].id)) Color.White else Gray2
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
    }
}