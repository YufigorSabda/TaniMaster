package com.example.tanimaster.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
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
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFDAEBD1))
                    .padding(padding)
            ) {
                ProfileContent(navController, authViewModel)
            }
        }
    )
}

@Composable
fun ProfileContent(navController: NavController, authViewModel: AuthViewModel) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            ProfileHeader()
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            ProfileOptions(navController, authViewModel)
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Versi Aplikasi TaniMaster 1.0.0",
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun ProfileHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            // Tempat untuk Foto Profil (Tambahkan resource jika ada)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Sigma Farm",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun ProfileOptions(navController: NavController, authViewModel: AuthViewModel) {
    val options = listOf(
        "Panduan",
        "Akun",
        "Keamanan",
        "Tem",
        "Histori",
        "Notifikasi",
        "About App"
    )

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            options.forEach { label ->
                ProfileOptionButton(label = label)
                if (label != options.last()) Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }
    }
}

@Composable
fun ProfileOptionButton(label: String) {
    TextButton(
        onClick = { /* Tambahkan logika tombol */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        navController = rememberNavController(),
        authViewModel = AuthViewModel()
    )
}
