package com.siri.multiscreenb2cappwithintegreirteapi.ui.screens

import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.siri.multiscreenb2cappwithintegreirteapi.navigation.NavScreens
import kotlinx.coroutines.delay
import com.siri.multiscreenb2cappwithintegreirteapi.R
import com.siri.multiscreenb2cappwithintegreirteapi.ui.theme.roboto

@Composable
fun SplashScreen(navController: NavController) {

    val scale = remember{
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true){
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800)
        )
        delay(1000L)
        navController.popBackStack()
        // Todo List
//        if(FirebaseAuth.getInstance().currentUser != null){
//            navController.navigate(NavScreens.MainScreenHolder.name)
//        }else{
//            navController.navigate(NavScreens.LoginScreen.name)
//        }
        // mock
        // เอา Firebase ออก แล้วใช้ if แบบ manual แทน
        val isLoggedIn = false // เปลี่ยนเป็น true เพื่อเทส MainScreen
        if (isLoggedIn) {
            navController.navigate(NavScreens.MainMenuScreen.route)
        } else {
            navController.navigate(NavScreens.LoginScreen.route)
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier.size(80.dp))
            {

                Image(painter = painterResource(id = R.drawable.banner_shop),
                    contentDescription = "logo",
                    modifier = Modifier.scale(scale.value))
            }
            Text(text="Happy Shopping!",
                modifier = Modifier.padding(top = 2.dp),
                style= TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold, fontFamily = roboto)
            )
        }
    }
}

@Composable
fun SplashScreenContent(scale: Float) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.size(150.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.banner_shop),
                    contentDescription = "logo",
                    modifier = Modifier.scale(scale)
                )
            }

            Text(
                text = "Shoppy!",
                modifier = Modifier.padding(top = 2.dp),
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = roboto
                )
            )
        }
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreenContent(scale = 0.9f)
}