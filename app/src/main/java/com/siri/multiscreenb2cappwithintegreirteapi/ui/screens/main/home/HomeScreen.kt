package com.siri.multiscreenb2cappwithintegreirteapi.ui.screen.main.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.siri.multiscreenb2cappwithintegreirteapi.R
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.product.ProductViewModel
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.components.ProductsItem
import com.siri.multiscreenb2cappwithintegreirteapi.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HomeScreen( ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        TopAppBarHeader()
        Spacer(Modifier.height(16.dp))
        OurProductsWithSearch()
        Spacer(Modifier.height(24.dp))
        BannerContent()
        Spacer(Modifier.height(24.dp))
        ProductCategory()
        Spacer(Modifier.height(24.dp))
        NewSection()
        Spacer(Modifier.height(24.dp))
        SaleSection()
//        ProductWidget()
    }
}

// Home tab content (ส่วนนี้คือหน้าหลักเดิมของคุณ)
@Composable
fun HomeContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        TopAppBarHeader()
        Spacer(Modifier.height(16.dp))
        OurProductsWithSearch()
        Spacer(Modifier.height(24.dp))
        BannerContent()
        Spacer(Modifier.height(24.dp))
        ProductCategory()
        Spacer(Modifier.height(24.dp))
        ProductWidget()
    }
}

@Composable
fun TopAppBarHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ElevatedCard(
            shape = RoundedCornerShape(12.dp)
        ) {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = "Menu"
                )
            }
        }
        ElevatedCard(
            shape = RoundedCornerShape(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "User",
                modifier = Modifier.size(50.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OurProductsWithSearch() {
    var search by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth()) {
//        Text(
//            buildAnnotatedString {
//                withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
//                    append("Our\n")
//                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
//                        append("Products")
//                    }
//                }
//            },
//            fontSize = 24.sp
//        )

        Spacer(Modifier.height(20.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = search,
                onValueChange = { search = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Search Products") },
                leadingIcon = {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
                },
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(Modifier.width(10.dp))

            ElevatedCard(
                shape = RoundedCornerShape(12.dp),
                onClick = { }
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.filter_list),
                        contentDescription = "Filter"
                    )
                }
            }
        }
    }
}

@Composable
fun BannerContent() {
    // Define the list of banners
    val bannerList = listOf(
        R.drawable.banner_product1,
        R.drawable.banner_product2,
        R.drawable.banner_product3
    )
    val pagerState = rememberPagerState(initialPage = 0) // Initialize pager state
    val coroutineScope = rememberCoroutineScope()

    // Auto slide every 3 seconds
    LaunchedEffect(key1 = pagerState.currentPage) {
        delay(3000)
        val nextPage = (pagerState.currentPage + 1) % bannerList.size
        coroutineScope.launch {
            pagerState.animateScrollToPage(nextPage) // Smooth scroll to the next page
        }
    }

    // UI Layout
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Pager for displaying banners
        HorizontalPager(
            state = pagerState // Use the pager state
            ,count = bannerList.size
            ,modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            // Display each banner image
            Image(
                painter = painterResource(id = bannerList[page]),
                contentDescription = "Banner Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Space between pager and indicator
        Spacer(modifier = Modifier.height(8.dp))

        // Pager indicator
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier,
            activeColor = MaterialTheme.colorScheme.primary,
            inactiveColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
            indicatorWidth = 12.dp,
            indicatorHeight = 4.dp,
            spacing = 8.dp
        )
    }
}

@Composable
fun ProductCategory() {
    val itemList = listOf("Sneakers", "Jacket", "Watch", "Watch")
    val categoryImagesList = listOf(
        R.drawable.ic_product1,
        R.drawable.ic_product1,
        R.drawable.ic_product1,
        R.drawable.ic_product1
    )

    LazyRow(modifier = Modifier
        .fillMaxWidth()) {
        items(itemList.size) { item ->
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .border(
                        color = if (item == 0) Orange else lightGrey,
                        width = 2.dp,
                        shape = RoundedCornerShape(10.dp)
                    )
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(categoryImagesList[item]), contentDescription = "",
                        modifier = Modifier.size(30.dp, 30.dp))
                    Text(
                        modifier = Modifier
                            .padding(
                                start = 5.dp,
                                end = 16.dp,
                                top = 8.dp,
                                bottom = 8.dp
                            ),
                        text = itemList[item],
                        color = if (item == 0) lightblack else Color.LightGray
                    )
                }

            }
            Spacer(modifier = Modifier.width(10.dp))
        }
    }
}
@Composable
fun NewSection(viewModel: ProductViewModel = hiltViewModel()) {
    val newProducts by viewModel.newProducts

    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("New", fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.weight(1f))
            Text("View all", fontSize = 12.sp)
        }
        Text("You Never seen Before", fontSize = 11.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            items(newProducts) { product ->
                ProductsItem(product = product)
            }
        }
    }
}



@Composable
fun SaleSection(viewModel: ProductViewModel = hiltViewModel()) {
    val newProducts by viewModel.saleProducts

    Column(modifier = Modifier.padding(horizontal = 10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Sale", fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.weight(1f))
            Text("View all", fontSize = 12.sp)
        }
        Text("You Never seen Before", fontSize = 11.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow {
            items(newProducts) { product ->
                ProductsItem(product = product)
            }
        }
    }
}


@Composable
fun ProductWidget() {
    val products = listOf(
        Triple("Nike Air Max 200", R.drawable.shooe_tilt_1, "240.00"),
        Triple("Nike Air Max 97", R.drawable.shoe_tilt_2, "220.00")
    )
    val tags = listOf("Trending Now", "Best Selling")

    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        items(products.size) { index ->
            ElevatedCard(
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.width(180.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.Gray
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(CircleShape)
                            .background(lightorange),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = products[index].second),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    Text(
                        text = products[index].first,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = black,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = tags[index],
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Orange,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "$ ${products[index].third}",
                        fontSize = 16.sp,
                        color = black,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewHomeScreen() {
    HomeScreen()
}