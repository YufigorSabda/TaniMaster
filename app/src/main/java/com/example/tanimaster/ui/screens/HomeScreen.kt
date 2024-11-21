package com.example.tanimaster.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tanimaster.R
import com.example.tanimaster.ui.components.BottomAppBar
import com.example.tanimaster.ui.theme.AuthState
import com.example.tanimaster.ui.theme.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, authViewModel: AuthViewModel) {
    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }

    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
//        topBar = {
//            HomeTopAppBar(title = "Home")
//        },
        bottomBar = {
            if (navController != null) {
                BottomAppBar(navController=navController)
            }
        },
        content = { padding ->
            Column (
                modifier = Modifier
                    .background(color = Color(0xFFDAEBD1))
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.home0),
                    contentDescription = "Home Kosong",
                    modifier = Modifier
                        .background(Color.Transparent)
                        .size(250.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text("No progress is made",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFFAB9090),
                    )
                )
            }

        }
    )
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController(), authViewModel = AuthViewModel())
}
