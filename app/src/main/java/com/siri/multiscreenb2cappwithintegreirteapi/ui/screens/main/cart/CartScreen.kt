package com.siri.multiscreenb2cappwithintegreirteapi.ui.screen.main.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.siri.multiscreenb2cappwithintegreirteapi.R
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.cart.CartViewModel
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.cart.CartItemView

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel()
) {
    val products by viewModel.productsInCart.collectAsState() // Flow/StateFlow

    if (products.isEmpty()) {
        EmptyCartView()
    } else {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(products) { product ->
                    CartItemView (
                        product = product,
                        onAdd = { viewModel.add(product) },
                        onRemove = { viewModel.remove(product) },
                        onDelete = { viewModel.delete(product) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            val totalPrice = products.sumOf { it.pPrice.toDoubleOrNull() ?: 0.0 * it.qua }
            Text(
                text = "Total: $${totalPrice}",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { viewModel.checkout() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("CHECK OUT")
            }
        }
    }
}


@Composable
fun EmptyCartView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.placeholder_error), // ใช้ชื่อไฟล์ของคุณเอง
            contentDescription = "Empty Bag",
            modifier = Modifier
                .width(250.dp)
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Empty Bag",
            fontSize = 22.sp,
            color = Color.Gray,
            style = MaterialTheme.typography.titleMedium
        )
    }
}



