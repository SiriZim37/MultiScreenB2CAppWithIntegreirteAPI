package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.product

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.siri.multiscreenb2cappwithintegreirteapi.R
import com.siri.multiscreenb2cappwithintegreirteapi.data.models.Product
import com.siri.multiscreenb2cappwithintegreirteapi.room.entitys.ProductEntity
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.components.ProductsItem
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.components.QuantityDialog
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.components.RatingBar

@Composable
fun ProductDetailsScreen(product: Product,
                         navController: NavController, // Pass navController here
                         newProducts: List<Product>,
                         productViewModel: ProductViewModel = hiltViewModel(),
                         onBack: () -> Unit) {

    var showDialog by remember { mutableStateOf(false) }

    LazyColumn(modifier = Modifier.fillMaxSize()) {

        item {
            Box {
                AsyncImage(
                    model = product.productImage,
                    contentDescription = product.productName,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(450.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { onBack() }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }

        item {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = product.productName,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = "€${product.productPrice}",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Text(
                    text = product.productBrand,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 8.dp)
                )

                RatingBar(rating = product.productRating)

                Text(
                    text = "Product Details",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = product.productDes,
                    fontSize = 13.sp,
                    color = Color.Gray,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        item {
            RecommendedSection(
                products = newProducts,
                navController = navController, // Pass navController here
                onProductClick = { clickedProduct ->
                    navController.navigate("ProductDetails/${clickedProduct.productId}")
                }
            )
        }

        item {
            Button(
                onClick = { showDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Add To Bag")
            }
        }
    }

    if (showDialog) {
        QuantityDialog (
            onDismiss = { showDialog = false },
            onAddToCart = { quantity ->
                // แปลง Product เป็น ProductEntity สำหรับบันทึก
                val productEntity = ProductEntity(
                    pName = product.productName,
                    qua = quantity,
                    pPrice = product.productPrice,
                    pPid = product.productId,
                    pImage = product.productImage
                )
                productViewModel.addProductToCart(productEntity)
                showDialog = false
            }
        )
    }
}


@Composable
fun RecommendedSection(
    products: List<Product>,
    navController: NavController, // Add navController parameter
    onProductClick: (Product) -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "You may also like",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(products) { product ->
                ProductsItem(
                    product = product,
                    onClick = { onProductClick(product) }
                )
            }
        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun ProductDetailsScreenPreview() {
//    val sampleProducts = listOf(
//        Product(
//            productName = "Decorative Wall Clock",
//            productId = "1",
//            productPrice = "45",
//            productDes = "A modern decorative wall clock with a minimalist design. It features a silent ticking mechanism and is perfect for living rooms and bedrooms.\n\nMaterial & Care\nWooden frame\nWipe with a dry cloth",
//            productRating = 4.5f,
//            productDisCount = "10%",
//            productHave = true,
//            productBrand = "HomeTime",
//            productImage = "https://images.squarespace-cdn.com/content/v1/5a8ec728f9a61e7fba3ec60b/1643623754362-WANW9PG5EI0R8NKP48RT/Milano-sofa-45-degree-opened.jpg",
//            productCategory = "Home & Living",
//            productNote = "HomeTime"
//        ),
//        Product(
//            productName = "Leather Storage Ottoman",
//            productId = "2",
//            productPrice = "120",
//            productDes = "A multi-functional ottoman that can be used for seating, storage, or as a coffee table. The leather finish gives it a luxurious feel.\n\nMaterial & Care\nLeather\nWipe clean with a damp cloth",
//            productRating = 4.8f,
//            productDisCount = "15%",
//            productHave = true,
//            productBrand = "LivingCo",
//            productImage = "https://images.squarespace-cdn.com/content/v1/5a8ec728f9a61e7fba3ec60b/1643623754362-WANW9PG5EI0R8NKP48RT/Milano-sofa-45-degree-opened.jpg",
//            productCategory = "Home & Living",
//            productNote = "LivingCo"
//        )
//    )
//
//    ProductDetailsScreen(
//        product = sampleProducts[0],
//        newProducts = sampleProducts,
//        onBack = {}
//    )
//}
