package com.example.tanimaster.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tanimaster.R
import com.example.tanimaster.ui.theme.AuthViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    authViewModel: AuthViewModel
) {
    Scaffold(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        content = { padding ->
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFDAEBD1))
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ProfileHeader()
                Spacer(modifier = Modifier.height(16.dp))
                LogoutButton(authViewModel)
            }
        }
    )
}

@Composable
fun ProfileHeader() {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.White, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_profile),
            contentDescription = "Profile Picture",
            modifier = Modifier.size(64.dp),
            tint = Color.Gray
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = "Sigma Farm",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black
    )
}

@Composable
fun LogoutButton(authViewModel: AuthViewModel) {
    var showConfirmationDialog by remember { mutableStateOf(false) }

    Button(
        onClick = { showConfirmationDialog = true },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(text = "Sign Out")
    }

    if (showConfirmationDialog) {
        AlertDialog(
            onDismissRequest = { showConfirmationDialog = false },
            title = { Text(text = "Konfirmasi Logout") },
            text = { Text(text = "Apakah Anda yakin ingin logout?") },
            confirmButton = {
                Button(onClick = {
                    authViewModel.signout() // Panggil signout dari ViewModel
                    showConfirmationDialog = false
                }) {
                    Text(text = "Ya")
                }
            },
            dismissButton = {
                TextButton(onClick = { showConfirmationDialog = false }) {
                    Text(text = "Tidak")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        navController = rememberNavController(),
        authViewModel = AuthViewModel() // Dummy ViewModel untuk preview
    )
}
