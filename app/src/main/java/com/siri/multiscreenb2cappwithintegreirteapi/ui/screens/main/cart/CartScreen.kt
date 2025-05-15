package com.siri.multiscreenb2cappwithintegreirteapi.ui.screen.main.cart

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CartScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Cart Screen - สินค้าในตะกร้า")
        // TODO: แสดงรายการสินค้าที่เพิ่มในตะกร้า
    }
}
