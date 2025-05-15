package com.siri.multiscreenb2cappwithintegreirteapi.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.siri.multiscreenb2cappwithintegreirteapi.ui.screens.main.home.HomeViewModel

@Composable
fun BottomNavigation(
    navController: NavHostController,
    email: String,
    signOut: () -> Unit,
) {


}