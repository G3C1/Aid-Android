package com.g3c1.oasis_android.feature_seat.presentation.seatlist

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.platform.LocalDensity
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@Composable
fun SeatListScreen(
    seatDataList: List<SeatDTO>,
    viewModel: SeatDataViewModel,
    scope: CoroutineScope,
    onSuccess: () -> Unit,
    displaySize: Array<Int>
) {
    val selectedValue = remember { mutableStateOf<Int?>(null) }
    val isSelectedItem: (Int) -> Boolean = { selectedValue.value == it }
    val onChangeState: (Int) -> Unit = { selectedValue.value = it }
    val (displaySizeWidth, displaySizeHeight) = displaySize
    val d = LocalDensity.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
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

            Box(modifier = Modifier.weight(1f).fillMaxWidth().padding(start = 10.dp, end = 10.dp)) {
                seatDataList.forEach {
                    Box(modifier = Modifier.offset((it.x * (displaySizeWidth / d.density - 150)).dp, (it.y * (displaySizeHeight / d.density - 200)).dp)) {
                        val color = if (!it.enabled) Gray else Orange
                        val textColor =
                            if (!it.enabled) Gray2 else if (it.enabled && isSelectedItem(
                                    it.seatId
                                )
                            ) Orange else Color.White
                        Column(
                            Modifier
                                .height(if (it.severalPeople >= 4) 160.dp else 90.dp)
                                .width(if (it.severalPeople >= 2) 160.dp else 90.dp)
                                .selectable(
                                    selected = isSelectedItem(it.seatId),
                                    onClick = { onChangeState(it.seatId) },
                                    enabled = it.enabled,
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
                                .background(if (it.enabled && isSelectedItem(it.seatId)) Color.White else color),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,

                            ) {
                            Text(
                                text = "${it.seatNumber}번",
                                color = textColor,
                                fontSize = 16.sp,
                                fontFamily = Font.pretendard,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "${it.severalPeople}인용",
                                color = textColor,
                                fontSize = 16.sp,
                                fontFamily = Font.pretendard,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 80.dp),
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
        }

        Column(
            Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            SeatSubmitButton(onClick = {
                scope.launch {
                    viewModel.patchSeatData(selectedValue.value!!.toLong())
                    onSuccess()
                }
            }, visibility = selectedValue.value != null)
        }
    }
}