package com.g3c1.oasis_android.feature_chat.presentation.util

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
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

    @Throws(IOException::class)
    fun assetFilePath(context: Context, assetName: String): String? {
        val file = File(context.filesDir, assetName)
        if (file.exists() && file.length() > 0) {
            return file.absolutePath
        }
        context.assets.open(assetName).use { `is` ->
            FileOutputStream(file).use { os ->
                val buffer = ByteArray(4 * 1024)
                var read: Int
                while (`is`.read(buffer).also { read = it } != -1) {
                    os.write(buffer, 0, read)
                }
                os.flush()
            }
            return file.absolutePath
        }
    }
}