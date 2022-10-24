package com.g3c1.oasis_android.feature_seat.presentation.seatlist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import com.g3c1.oasis_android.feature_seat.data.dto.SeatDTO
import com.g3c1.oasis_android.feature_seat.presentation.seatlist.component.SeatSubmitButton
import com.g3c1.oasis_android.feature_seat.presentation.vm.SeatDataViewModel
import com.g3c1.oasis_android.ui.theme.Font
import com.g3c1.oasis_android.ui.theme.Gray
import com.g3c1.oasis_android.ui.theme.Gray2
import com.g3c1.oasis_android.ui.theme.Orange


@Composable
fun SeatListScreen(viewModel: SeatDataViewModel) {
    val selectedValue = remember { mutableStateOf<Int?>(null) }
    val isSelectedItem: (Int) -> Boolean = { selectedValue.value == it }
    val onChangeState: (Int) -> Unit = { selectedValue.value = it }
    Column(Modifier.fillMaxSize()) {
        val seatDataList = listOf(
            SeatDTO(
                seated = true,
                seatId = 1,
                seatNumber = 1,
                severalPeople = 1
            ),
            SeatDTO(
                seated = false,
                seatId = 2,
                seatNumber = 2,
                severalPeople = 2
            ),
            SeatDTO(
                seated = false,
                seatId = 3,
                seatNumber = 3,
                severalPeople = 4
            ),
            SeatDTO(
                seated = false,
                seatId = 4,
                seatNumber = 4,
                severalPeople = 4
            ),

            )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )
        Text(
            text = "자리선택",
            fontSize = 30.sp,
            color = Orange,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
        )
        Column {
            seatDataList.forEach { item ->
                val color = if (item.seated) Gray else Orange
                val textColor =
                    if (item.seated) Gray2 else if (!item.seated && isSelectedItem(item.seatId)) Orange else Color.White
                Column(
                    Modifier
                        .size(if (item.severalPeople >= 4) 160.dp else 90.dp)
                        .selectable(
                            selected = isSelectedItem(item.seatId),
                            onClick = { onChangeState(item.seatId); },
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
                    horizontalAlignment = Alignment.CenterHorizontally,
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
            }
        }
        Row(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Gray)
                        .clip(RoundedCornerShape(3f))
                ) {}
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "사용중")
            }
            Spacer(modifier = Modifier.width(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier
                        .size(10.dp)
                        .background(Orange)
                        .clip(RoundedCornerShape(3f))
                ) {}
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "빈자리")
            }
            Spacer(modifier = Modifier.width(8.dp))
        }
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SeatSubmitButton(onClick = {
                viewModel.patchSeatData(selectedValue.value!!)
            }, visibility = selectedValue.value != null)
        }
    }
}