package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.components

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.siri.multiscreenb2cappwithintegreirteapi.R
import com.siri.multiscreenb2cappwithintegreirteapi.data.models.Product
import com.siri.multiscreenb2cappwithintegreirteapi.navigation.NavScreens


@Composable
fun ProductsItem(product: Product,
                 onClick: () -> Unit, // Accept onClick as a lambda parameter
                 modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .width(180.dp)
            .padding(8.dp)
            .clickable { onClick() }, // Handle the click event
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier
                .height(180.dp)
                .fillMaxWidth()
        ) {

            AsyncImage(
                model = product.productImage,
                contentDescription = product.productName,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                error = painterResource(id = R.drawable.placeholder_error),
                placeholder = painterResource(id = R.drawable.placeholder_error),
            )
            Log.d("ImageURL", "URL: ${product.productImage}")
        }

        Spacer(modifier = Modifier.height(6.dp))

        if (product.productDisCount.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .background(Color.Red, RoundedCornerShape(4.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            ) {
                Text(
                    text = "-${product.productDisCount}",
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }

        RatingBar(product.productRating)

        Text(
            text = product.productBrand,
            fontSize = 13.sp,
            color = Color.Gray
        )
        Text(
            text = product.productName,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "€${product.productPrice}",
            fontSize = 13.sp,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun RatingBar(rating: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        repeat(5) { index ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = if (index < rating.toInt()) Color(0xFFFFC107) else Color.LightGray,
                modifier = Modifier.size(14.dp)
            )
        }
    }
}
