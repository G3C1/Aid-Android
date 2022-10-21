package com.g3c1.oasis_android.feature_seat.presentation.seatlist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.feature_seat.data.data_soure.SeatData
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Gray
import com.g3c1.oasis_android.ui.theme.Gray2
import com.g3c1.oasis_android.ui.theme.Orange


@Composable
fun SeatRadioButton(seatDataList: List<SeatData>) {
    val selectedValue = remember { mutableStateOf<Int?>(null) }
    val isSelectedItem: (Int) -> Boolean = { selectedValue.value == it }
    val onChangeState: (Int) -> Unit = { selectedValue.value = it }

    Column {
        seatDataList.forEach { item ->
            val color = if (item.seated) Gray else Orange
            val textColor =
                if (item.seated) Gray2 else if (!item.seated && isSelectedItem(item.seatId)) Orange else Color.Black
            Column(
                Modifier
                    .size(if (item.severalPeople >= 4) 160.dp else 90.dp)
                    .selectable(
                        selected = isSelectedItem(item.seatId),
                        onClick = { onChangeState(item.seatId) },
                        enabled = !item.seated,
                        role = Role.RadioButton,
                    )
                    .padding(8.dp)
                    .clip(
                        shape = RoundedCornerShape(30f),
                    )
                    .border(
                        shape = RoundedCornerShape(30f),
                        color = color,
                        width = 3.dp
                    )
                    .background(if (!item.seated && isSelectedItem(item.seatId)) Color.White else color),
                horizontalAlignment = CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ) {
                Text(
                    text = "${item.seatNumber}번",
                    color = textColor,
                    fontSize = 16.sp,
                    fontFamily = Font.pretendard,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${item.seatNumber}인용",
                    color = textColor,
                    fontSize = 16.sp,
                    fontFamily = Font.pretendard,
                    fontWeight = FontWeight.SemiBold
                )
            }


//            RadioButton(
//                enabled = item.seated,
//                onClick = { selectedValue.value = item.seatId },
//                selected = selectedValue.value == item.seatId,
//                colors = RadioButtonDefaults.colors(
//                    selectedColor = Color.Green,
//                    unselectedColor = Orange,
//                    disabledColor = Color.LightGray
//                )
//            )
        }
    }
}