package com.g3c1.oasis_android.feature_chat.presentation.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object Utils {
    @RequiresApi(Build.VERSION_CODES.O)
    fun formattedTime(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("a hh:mm", Locale("ko"))
        var formatted = current.format(formatter)
        if (current.format(DateTimeFormatter.ofPattern("a")) == "AM" && current.format(
                DateTimeFormatter.ofPattern("hh")
            ) == "12"
        ) {
            formatted = "${formatted.substring(0, 2)} 00:${formatted.substring(6, 8)}"
        }
        return formatted
    }
}