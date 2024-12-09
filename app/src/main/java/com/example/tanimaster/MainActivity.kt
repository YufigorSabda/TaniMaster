package com.example.tanimaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tanimaster.ui.pages.KeuanganPage
import com.example.tanimaster.ui.screens.AddTaskScreen
import com.example.tanimaster.ui.screens.HomeScreen
import com.example.tanimaster.ui.screens.LoginScreen
import com.example.tanimaster.ui.screens.RegisterScreen
import com.example.tanimaster.ui.screens.WelcomeScreen
import com.example.tanimaster.ui.theme.TaniMasterTheme
import com.example.tanimaster.ui.viewmodel.AuthViewModel
import com.example.tanimaster.ui.screens.InputModalScreen
import com.example.tanimaster.ui.screens.PengeluaranScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val authViewModel: AuthViewModel = viewModel()
            TaniMasterTheme() {
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") { WelcomeScreen(navController = navController) }
                    composable("signin") { LoginScreen(navController = navController, authViewModel = authViewModel) }
                    composable("signup") { RegisterScreen(navController = navController, authViewModel = authViewModel) }
                    composable("home") { HomeScreen(navController = navController, authViewModel = authViewModel) }
                    composable("addtask") { AddTaskScreen(navController = navController, modifier = Modifier) }
                    composable("input_modal_screen") { InputModalScreen(navController = navController) }
                    composable("pengeluaran_screen") { PengeluaranScreen(navController = navController) }
                    composable("keuangan") { KeuanganPage(navController = navController) }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    TaniMasterTheme() {
        WelcomeScreen(navController = rememberNavController())
    }
}