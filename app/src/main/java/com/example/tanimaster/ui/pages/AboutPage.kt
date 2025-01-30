package com.example.tanimaster.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tanimaster.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutPage(navController: androidx.navigation.NavController, modifier: Modifier = Modifier) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Tentang Aplikasi", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF55AA68),
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) { // Perbaikan: Tambahkan `navController` untuk navigasi kembali
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Kembali",
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .navigationBarsPadding()
                .statusBarsPadding()
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Nama aplikasi
            Image(
                painter = painterResource(id = R.drawable.title_app),
                contentDescription = "Tani Master",
                modifier = Modifier
                    .size(120.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Logo aplikasi
            Image(
                painter = painterResource(id = R.drawable.ic_logo), // Pastikan logo ada di folder drawable
                contentDescription = "Logo Tani Master",
                modifier = Modifier.size(120.dp)
            )

            Text(
                text = "Tentang Aplikasi TaniMaster",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = "TaniMaster adalah aplikasi yang dirancang untuk membantu petani mengelola aktivitas pertanian dengan lebih efisien. Aplikasi ini menyediakan fitur-fitur seperti panduan bertani, pengelolaan akun, keamanan, tema, histori, notifikasi, dan lainnya. Versi ini adalah 1.0.0.",
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}