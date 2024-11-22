package com.example.tanimaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tanimaster.ui.screens.HomeScreen
import com.example.tanimaster.ui.screens.ProfileScreen
import com.example.tanimaster.ui.theme.TaniMasterTheme
import com.example.tanimaster.ui.theme.AuthViewModel
import com.example.tanimaster.ui.theme.screens.SignInScreen
import com.example.tanimaster.ui.screens.SignUpScreen
import com.example.tanimaster.ui.theme.screens.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val authViewModel: AuthViewModel = viewModel() // Inisialisasi AuthViewModel

            TaniMasterTheme {
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") { WelcomeScreen(navController = navController) }
                    composable("signin") { SignInScreen(navController = navController, authViewModel = authViewModel) }
                    composable("signup") {SignUpScreen(navController = navController, authViewModel = authViewModel)}
                    composable("home") { HomeScreen(navController = navController, authViewModel = authViewModel) }
                    composable("profile") { ProfileScreen(navController = navController) }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    TaniMasterTheme {
        WelcomeScreen(navController = rememberNavController())
    }
}
