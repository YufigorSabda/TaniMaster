@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.tanimaster.ui.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InventarisProduksiPage(modifier: Modifier = Modifier, navController: NavController) {
    var selectedTabIndex by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Inventaris & Produksi",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF55AA68)
                )
            )
        },
        content = {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(horizontal = 16.dp) // Pastikan hanya ada padding horizontal
            ) {
                // Tabs
                TabRow(
                    selectedTabIndex = selectedTabIndex,
                    containerColor = Color(0xFFF6F6F6),
                    contentColor = Color(0xFF55AA68)
                ) {
                    Tab(
                        selected = selectedTabIndex == 0,
                        onClick = { selectedTabIndex = 0 },
                        text = { Text("Produksi", fontWeight = FontWeight.Bold) }
                    )
                    Tab(
                        selected = selectedTabIndex == 1,
                        onClick = { selectedTabIndex = 1 },
                        text = { Text("Inventaris", fontWeight = FontWeight.Bold) }
                    )
                }

                // Mengurangi atau menghapus spacer setelah TabRow agar tidak ada ruang kosong yang tidak perlu
                Spacer(modifier = Modifier.height(8.dp)) // Spacer yang lebih kecil

                // Tab Content
                when (selectedTabIndex) {
                    0 -> ProduksiContent(navController = navController)
                    1 -> InventarisContent(navController = navController)
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Tombol Export di bagian bawah
                ExportButton(onClick = { /* Tambahkan logika export */ })
            }
        }
    )
}

@Composable
fun ProduksiContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SectionCard(title = "Jumlah Penanaman") { /* Arahkan ke halaman Jumlah Penanaman */ }
        SectionCard(title = "Hasil Panen") { /* Arahkan ke halaman Hasil Panen */ }
    }
}

@Composable
fun InventarisContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SectionCard(title = "Inventory Bahan Bibit") { /* Arahkan ke halaman Bahan Bibit */ }
        SectionCard(title = "Inventory Bahan Baku") { /* Arahkan ke halaman Bahan Baku */ }
    }
}

@Composable
fun SectionCard(title: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF55AA68)
            )
        }
    }
}

@Composable
fun ExportButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF55AA68)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Export Data", color = Color.White, fontWeight = FontWeight.Bold)
    }
}
