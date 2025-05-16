package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.profile


import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.siri.multiscreenb2cappwithintegreirteapi.R


@Composable
fun ProfileScreen(  viewModel: ProfileViewModel = hiltViewModel() ) {
    val user = viewModel.user.collectAsState().value

    val mainTextColor = Color(0xFF000000) // แทน @color/mainText
    val textAdColor = Color(0xFF888888)   // แทน @color/textAd
    val backgroundColor = Color(0xFFF0F0F0) // แทน @color/background

    val metropolisFont = FontFamily(Font(R.font.roboto_regular)) // โหลดฟอนต์

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 10.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "My Profile",
                fontFamily = metropolisFont,
                color = mainTextColor,
                fontSize = 23.sp,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

        }

        Spacer(modifier = Modifier.height(10.dp))

        // Profile Info Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val imagePainter = rememberAsyncImagePainter(
                model = user?.profileImageUri ?: R.drawable.ic_profile
            )

            // Circle Image with border
            Image(
                painter = imagePainter,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(70.dp)
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = CircleShape
                    )
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxHeight()
            ) {
                Text(
                    text = user?.let { "${it.firstName} ${it.lastName}" } ?: "Loading...",
                    fontFamily = metropolisFont,
                    color = mainTextColor,
                    fontSize = 18.sp
                )
                Text(
                    text = user?.email ?: "Loading...",
                    fontFamily = metropolisFont,
                    color = textAdColor,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Upload Image Button (visibility gone means don't show, ถ้าอยากโชว์ก็ลบ .alpha)
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
            enabled = false // ปิดใช้งานเหมือน visibility gone
        ) {
            Text("Upload Image", fontFamily = metropolisFont)
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Cards - ตัวอย่างแค่ 1 ใบ (My Orders)
        ProfileCard(
            title = "My Orders",
            subtitle = "you have no orders",
            onClick = { /*TODO*/ },
            mainTextColor = mainTextColor,
            textAdColor = textAdColor,
            metropolisFont = metropolisFont
        )
        // เพิ่ม ProfileCard อื่น ๆ ตาม XML ได้เลย
        ProfileCard(
            title = "Shipping addresses",
            subtitle = "No Address",
            onClick = { /*TODO*/ },
            mainTextColor = mainTextColor,
            textAdColor = textAdColor,
            metropolisFont = metropolisFont
        )
        ProfileCard(
            title = "Payment methods",
            subtitle = "You Have no cart",
            onClick = { /*TODO*/ },
            mainTextColor = mainTextColor,
            textAdColor = textAdColor,
            metropolisFont = metropolisFont
        )
        ProfileCard(
            title = "Promo codes",
            subtitle = "You have special promo codes",
            onClick = { /*TODO*/ },
            mainTextColor = mainTextColor,
            textAdColor = textAdColor,
            metropolisFont = metropolisFont
        )
        ProfileCard(
            title = "Settings",
            subtitle = "Notifications, password",
            onClick = { /*TODO*/ },
            mainTextColor = mainTextColor,
            textAdColor = textAdColor,
            metropolisFont = metropolisFont
        )
    }
}

@Composable
fun ProfileCard(
    title: String,
    subtitle: String,
    onClick: () -> Unit,
    mainTextColor: Color,
    textAdColor: Color,
    metropolisFont: FontFamily,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(vertical = 5.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F0F0)) ,
        elevation = CardDefaults.cardElevation(0.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontFamily = metropolisFont,
                    color = mainTextColor,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = subtitle,
                    fontFamily = metropolisFont,
                    color = textAdColor,
                    fontSize = 12.sp
                )
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Arrow",
                modifier = Modifier.size(22.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewProfile(){
    ProfileScreen()
}
