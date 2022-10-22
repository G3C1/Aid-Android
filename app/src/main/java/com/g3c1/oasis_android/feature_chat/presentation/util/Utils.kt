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
        val formattedAmPm = current.format(DateTimeFormatter.ofPattern("a", Locale("ko")))
        val formattedMin = current.format(DateTimeFormatter.ofPattern("mm"))
        val hour = DateTimeFormatter.ofPattern("HH").toString().toInt()
        val formattedHour: Int

        if (hour <= 12)
            formattedHour = hour
        else
            formattedHour = hour - 12

        return "$formattedAmPm $formattedHour:$formattedMin"
    }
}