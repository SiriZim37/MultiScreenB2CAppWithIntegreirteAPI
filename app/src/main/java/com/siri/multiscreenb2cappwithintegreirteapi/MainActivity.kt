package com.siri.multiscreenb2cappwithintegreirteapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.siri.multiscreenb2cappwithintegreirteapi.navigation.ShopKartNavigation
import com.siri.multiscreenb2cappwithintegreirteapi.ui.theme.MultiScreenB2CAppWithIntegreirteAPITheme
import com.siri.multiscreenb2cappwithintegreirteapi.ui.theme.ShopKartTheme
import dagger.hilt.android.AndroidEntryPoint

// เพื่อให้ Hilt ทำงานได้
// ใส่ @AndroidEntryPoint ที่ MainActivity
// ตรวจว่า Application ของคุณมี @HiltAndroidApp
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShopKartTheme {
                ShopKartApp()
            }
        }
    }
}

@Composable
fun ShopKartApp() {
    MultiScreenB2CAppWithIntegreirteAPITheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            ShopKartNavigation()
        }
    }
}

