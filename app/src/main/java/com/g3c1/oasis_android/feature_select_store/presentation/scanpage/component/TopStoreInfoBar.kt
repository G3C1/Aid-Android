package com.g3c1.oasis_android.feature_select_store.presentation.scanpage.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopStoreInfoBar(storeName: String, storeIntroduce: String, storeLogoUrl: String) {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .shadow(10.dp)
                .fillMaxWidth(0.95f)
                .fillMaxHeight(0.15f)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.size(10.dp))
            StoreLogo(url = storeLogoUrl)
            Spacer(modifier = Modifier.size(10.dp))
            Column {
                StoreName(storeName = storeName)
                StoreIntroduce(storeIntroduce = storeIntroduce)
            }
        }
    }
}