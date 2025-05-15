package com.siri.multiscreenb2cappwithintegreirteapi.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.siri.multiscreenb2cappwithintegreirteapi.utils.ShopKartUtils


@Composable
fun BottomNavBar(
    navHostController: NavHostController, // ใช้ควบคุมการนำทางระหว่างหน้าจอ
    onItemSelected: (BottomNavScreens) -> Unit  //callback ที่จะถูกเรียกเมื่อผู้ใช้แตะเลือกเมนู
) {

    val navBackStackEntry by navHostController.currentBackStackEntryAsState() //ตรวจสอบเมนูปัจจุบันที่เลือกอยู่
    val currentDestination = navBackStackEntry?.destination //ใช้ดึง route ปัจจุบันที่ผู้ใช้อยู่ เพื่อใช้ตรวจสอบว่าเมนูไหนกำลังถูกเลือก (isSelected)

    val items = BottomNavScreens.Items.list // สร้างรายการเมนู
    val padding = 40.dp

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
            .padding(start = padding, end = padding, top = 35.dp, bottom = 10.dp),
        shape = RoundedCornerShape(40.dp),
        color = ShopKartUtils.darkBlue,
    ) {
        Row( // วางเมนูใน Row วนรายการแต่ละเมนูและสร้างปุ่มเมนู (BottomNavBarItem) เช็คว่าหน้านี้ถูกเลือกอยู่หรือไม่ (isSelected) ถ้าแตะแล้วจะ navigate() ไปยัง route ของเมนูนั้น
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { item ->
                val isSelected = currentDestination?.hierarchy?.any { it.route == item.route } == true
                BottomNavBarItem(item = item, isSelected = isSelected) {
                    onItemSelected(item)
                    navHostController.navigate(item.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        // restoreState = true // Optional
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavBarItem( // BottomNavBarItem: ปุ่มเมนู เปลี่ยนสีเมื่อถูกเลือก
    item: BottomNavScreens,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val contentColor = if (isSelected) Color.White else Color.Gray

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .clickable(onClick = onClick)
                .width(55.dp)
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = item.icon!!),
                    contentDescription = item.title,
                    tint = contentColor
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BottomNavBarPreview() {
    val navController = rememberNavController()

    BottomNavBar(
        navHostController = navController,
        onItemSelected = { /* No-op for preview */ }
    )
}
