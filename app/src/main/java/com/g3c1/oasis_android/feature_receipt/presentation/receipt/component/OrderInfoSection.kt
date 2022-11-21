package com.g3c1.oasis_android.feature_receipt.presentation.receipt.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.g3c1.oasis_android.feature_receipt.data.dto.RemoteOrderedMenuInfoDTO

@Composable
fun OrderInfoSection(list: List<RemoteOrderedMenuInfoDTO>) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        items(list.size) { index ->
            OrderItems(list[index])
        }
    }
}