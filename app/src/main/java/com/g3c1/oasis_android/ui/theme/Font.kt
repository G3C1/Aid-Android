package com.g3c1.oasis_android.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.g3c1.oasis_android.R

object Font {
    val pretendard = FontFamily(
        Font(R.font.pretendard_black, FontWeight.Black, FontStyle.Normal),
        Font(R.font.pretendard_bold, FontWeight.Bold, FontStyle.Normal),
        Font(R.font.pretendard_extra_bold, FontWeight.ExtraBold, FontStyle.Normal),
        Font(R.font.pretendard_extra_light, FontWeight.ExtraLight, FontStyle.Normal),
        Font(R.font.pretendard_light, FontWeight.Light, FontStyle.Normal),
        Font(R.font.pretendard_medium, FontWeight.Medium, FontStyle.Normal),
        Font(R.font.pretendard_regular, FontWeight.Normal, FontStyle.Normal),
        Font(R.font.pretendard_semi_bold, FontWeight.SemiBold, FontStyle.Normal),
        Font(R.font.pretendard_thin, FontWeight.Thin, FontStyle.Normal),
    )
}