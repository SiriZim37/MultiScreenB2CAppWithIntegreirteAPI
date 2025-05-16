package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.cart


import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.siri.multiscreenb2cappwithintegreirteapi.room.entitys.ProductEntity

@Composable
fun CartItemView(
    product: ProductEntity,
    onAdd: (ProductEntity) -> Unit,
    onRemove: (ProductEntity) -> Unit,
    onDelete: (ProductEntity) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEFEFEF))
    ) {
        Row(Modifier.fillMaxSize()) {
            Image(
                painter = rememberAsyncImagePainter(product.pImage),
                contentDescription = null,
                modifier = Modifier
                    .width(120.dp)
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = product.pName, fontWeight = FontWeight.Bold, maxLines = 1)
                Text(text = "$${product.pPrice}", color = Color.Gray, fontSize = 14.sp)

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { onRemove(product) }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Decrease")
                    }

                    Text("${product.qua}", fontSize = 18.sp, modifier = Modifier.width(32.dp), textAlign = TextAlign.Center)

                    IconButton(onClick = { onAdd(product) }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Increase")
                    }
                }
            }

            IconButton(
                onClick = { onDelete(product) },
                modifier = Modifier
                    .align(Alignment.Top)
                    .padding(8.dp)
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Remove")
            }
        }
    }
}

