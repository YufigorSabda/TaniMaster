package com.example.tanimaster.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tanimaster.ui.components.ButtonText

@Composable
fun SettingPage(modifier: Modifier = Modifier, navController: NavController, onLogout: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        ProfileHeader(modifier = Modifier.padding(top = 8.dp, bottom = 16.dp))


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                ProfileOptions(navController)
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                ButtonText(
                    text = "Logout",
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onLogout
                )
            }
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Versi Aplikasi TaniMaster 1.0.0",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun ProfileHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            // Tempat untuk Foto Profil
        }
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = "Sigma Farm",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }
}

@Composable
fun ProfileOptions(navController: NavController) {
    val options = listOf(
        "Panduan",
        "Akun",
        "Keamanan",
        "Tema",
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
            .padding(vertical = 10.dp, horizontal = 14.dp)
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}
