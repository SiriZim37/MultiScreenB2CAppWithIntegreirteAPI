package com.siri.multiscreenb2cappwithintegreirteapi.ui.screen.main.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.siri.multiscreenb2cappwithintegreirteapi.R
import com.siri.multiscreenb2cappwithintegreirteapi.data.models.Category
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.components.CategoryCard


val cateList = listOf(
    Category("Home & Kitchen", "https://images.unsplash.com/photo-1571066811602-716837d6815c?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"),
    Category("Lighting", "https://images.unsplash.com/photo-1582719478250-c89cae4dc85b?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"),
    Category("Bath & Towels", "https://images.unsplash.com/photo-1604917877937-206eb4b8f7cb?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"),
    Category("Furniture", "https://images.unsplash.com/photo-1524758631624-e2822e304c36?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"),
    Category("Storage & Organization", "https://images.unsplash.com/photo-1602592585723-4d33de998b3e?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"),
    Category("Office Supplies", "https://images.unsplash.com/photo-1558692024-d2b637de1414?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"),
    Category("Tableware", "https://images.unsplash.com/photo-1562059390-a761a084768e?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"),
    Category("Bedding", "https://images.unsplash.com/photo-1616627982458-35c50a6481d0?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"),
    Category("Rugs & Carpets", "https://images.unsplash.com/photo-1610576660724-9b259e8583d6?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80"),
    Category("Storage Furniture", "https://images.unsplash.com/photo-1620295747226-3c2b38038fd6?ixlib=rb-4.0.3&auto=format&fit=crop&w=800&q=80")
)

@Composable
fun CategoryScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Banner
        item {
            Banner()
        }

        // Title before categories
        item {
            Text(
                text = "Shop by Category",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }

        // Category Section Header (ใหม่)
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Categories",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "View All",
                    color = Color.Blue,
                    modifier = Modifier.clickable { /* TODO: Handle click */ }
                )
            }
        }

        // Categories Grid (แปลงเป็น items แทน item)
        items(cateList.chunked(2)) { rowCategories ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                for (category in rowCategories) {
                    CategoryCard(
                        modifier = Modifier.weight(1f),
                        imageUrl = category.imageUrl,
                        title = category.title
                    )
                }
                // กรณีจำนวนคี่ เติม Spacer เพื่อจัด layout ให้สมดุล
                if (rowCategories.size < 2) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
@Composable
fun Banner() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner_product2),
            contentDescription = "Banner",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(bottom = 40.dp, start = 20.dp)
        ) {
            Text(
                text = "Product Sale",
                fontSize = 32.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                maxLines = 2
            )
            Button(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .padding(top = 10.dp)
                    .width(150.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black.copy(alpha = 0.7f))
            ) {
                Text(text = "Check", color = Color.White)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewCategoryScreen() {
    CategoryScreen()
}