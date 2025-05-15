package com.siri.multiscreenb2cappwithintegreirteapi.ui.screen.main.fav

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Favorite Screen - รายการที่ถูกใจ")
        // TODO: แสดงรายการสินค้าที่ผู้ใช้กดถูกใจ
    }
}
