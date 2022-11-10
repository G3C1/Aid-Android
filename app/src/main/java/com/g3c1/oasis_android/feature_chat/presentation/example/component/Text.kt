package com.g3c1.oasis_android.feature_chat.presentation.example.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_chat.presentation.util.Utils
import com.g3c1.oasis_android.ui.theme.*

@Composable
fun ChatTextField(text: String, onValueChange: (String) -> Unit) {

    TextField(
        value = text,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth(0.8f),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Gray3,
            textColor = Gray4,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Orange
        ),
        placeholder = {
            Text(
                text = "질문을 입력해주세요.",
                fontFamily = Font.pretendard,
                fontWeight = FontWeight.Medium,
                color = Gray7
            )
        },
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontFamily = Font.pretendard,
            fontWeight = FontWeight.Medium
        ),
        maxLines = 5,
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatText(text: String) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = Utils.formattedTime(), style = TextStyle(
                color = Gray6,
                fontSize = 11.sp,
                fontFamily = Font.pretendard,
                fontWeight = FontWeight.Medium
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.size(8.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Gray5)
                    .widthIn(0.dp, 250.dp)
            ) {
                Text(
                    text = text, modifier = Modifier.padding(8.dp), style = TextStyle(
                        color = Color.Black,
                        fontFamily = Font.pretendard,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp
                    )
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Orage2)
                    .width(40.dp)
                    .height(40.dp),
                contentAlignment = Alignment.Center
            )
            {
                Image(painterResource(id = R.drawable.ic_user_profile), contentDescription = "UserProfile")
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TemiText(text: String) {
    Row(
        verticalAlignment = Alignment.Bottom
    ) {
        Row(
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Orage2)
                    .width(40.dp)
                    .height(40.dp),
                contentAlignment = Alignment.Center
            )
            {
                Image(painterResource(id = R.drawable.aide), contentDescription = "TemiProfile")
            }
            Spacer(modifier = Modifier.size(8.dp))
            Column {
                Text(
                    text = "에이드", style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = Font.pretendard,
                        fontWeight = FontWeight.Medium
                    )
                )
                Spacer(modifier = Modifier.size(4.dp))
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Gray5)
                        .widthIn(0.dp, 250.dp)
                ) {
                    Text(
                        text = text, modifier = Modifier.padding(8.dp), style = TextStyle(
                            color = Color.Black,
                            fontFamily = Font.pretendard,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.size(8.dp))
        }
        Text(
            text = Utils.formattedTime(), style = TextStyle(
                color = Gray6,
                fontSize = 11.sp,
                fontFamily = Font.pretendard,
                fontWeight = FontWeight.Medium
            )
        )
    }
}