package com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.runtime.Composable

@Composable
fun AnimatiedStoreSelectButton(visible: Boolean, onClick: () -> Unit) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            initialOffsetY = { 400 },
            animationSpec = tween(durationMillis = 600, easing = LinearOutSlowInEasing)
        ),
        exit = slideOutVertically(
            targetOffsetY = { 400 },
            animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing)
        )
    ) {
        StoreSelectButton {
            onClick()
        }
    }
}

@Composable
fun AnimatiedTopStoreInfoBar(
    visible: Boolean,
    storeName: String,
    storeIntroduce: String,
    storeLogoUrl: String
) {
    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically(
            initialOffsetY = { -400 },
            animationSpec = tween(durationMillis = 600, easing = LinearOutSlowInEasing)
        ),
        exit = slideOutVertically(
            targetOffsetY = { -400 },
            animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing)
        )
    ) {
        TopStoreInfoBar(
            storeName = storeName,
            storeIntroduce = storeIntroduce,
            storeLogoUrl = storeLogoUrl
        )
    }
}