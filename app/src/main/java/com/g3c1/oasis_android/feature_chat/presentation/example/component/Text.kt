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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.g3c1.oasis_android.R
import com.g3c1.oasis_android.feature_chat.presentation.util.Utils
import com.g3c1.oasis_android.ui.theme.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

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
        placeholder = { Text(text = "질문을 입력해주세요.") },
        textStyle = TextStyle(
            fontSize = 16.sp
        ),
        maxLines = 5,
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChatText(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = Utils.formattedTime() , style = TextStyle(
                color = Gray6,
                fontSize = 11.sp
            )
        )
        Spacer(modifier = Modifier.size(8.dp))
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Gray5)
        ) {
            Text(text = text, modifier = Modifier.padding(8.dp))
        }
        Spacer(modifier = Modifier.size(5.dp))
        Image(
            painter = painterResource(id = R.drawable.chat_text_shape),
            contentDescription = "",
            modifier = Modifier.rotate(180f)
        )
        Spacer(modifier = Modifier.size(5.dp))
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(Orage2)
                .width(40.dp)
                .height(40.dp),
            contentAlignment = Alignment.Center
        )
        {
            Text(text = "")
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TemiText(text: String) {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("a HH:mm", Locale("ko"))
    val formatted = current.format(formatter)
    Row(verticalAlignment = Alignment.CenterVertically) {
        Row(
            verticalAlignment = Alignment.CenterVertically
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
                Text(text = "")
            }
            Spacer(modifier = Modifier.size(5.dp))
            Image(
                painter = painterResource(id = R.drawable.chat_text_shape),
                contentDescription = ""
            )
            Spacer(modifier = Modifier.size(5.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Gray5)
            ) {
                Text(text = text, modifier = Modifier.padding(8.dp))
            }
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = formatted, style = TextStyle(
                    color = Gray6,
                    fontSize = 11.sp
                )
            )
        }
    }
}