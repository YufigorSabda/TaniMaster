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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
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

                Spacer(modifier = Modifier.height(8.dp)) // Spacer yang lebih kecil

                // Tab Content
                when (selectedTabIndex) {
                    0 -> ProduksiContent(navController = navController)
                    1 -> InventarisContent(navController = navController)
                }
            }
        }
    )
}

@Composable
fun ProduksiContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        // Jumlah Penanaman Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Jumlah Penanaman",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF55AA68)
                )
                Spacer(modifier = Modifier.height(8.dp))
                ButtonText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Tambah Data Penanaman",
                    onClick = {

                        navController.navigate("input_penanaman_screen")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Tabel Jumlah Bibit Ditanam
                HistoryTable(
                    headers = listOf("Nama Bibit", "Jumlah (kg)", "Waktu Ditanam"),
                    rows = listOf(
                        listOf("Padi", "50", "2024-11-01"),
                        listOf("Jagung", "30", "2024-11-02"),
                        listOf("Wheat", "20", "2024-11-03"),
                        listOf("Barley", "40", "2024-11-04"),
                        listOf("Sorghum", "60", "2024-11-05")
                    )
                )
            }
        }

        // Hasil Panen Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Hasil Panen",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF55AA68)
                )
                Spacer(modifier = Modifier.height(8.dp))
                ButtonText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Input Hasil Panen (kg)",
                    onClick = { navController.navigate("input_hasil_panen_screen") }
                )


                Spacer(modifier = Modifier.height(8.dp))
                // Tabel Hasil Panen
                HistoryTable(
                    headers = listOf("Jenis Tumbuhan","Jumlah(Kg)", "Harga Jual"),
                    rows = listOf(
                        listOf("Padi","100", "Rp 2,500,000"),
                        listOf("Jagung","100", "Rp 2,500,000"),
                        listOf("Wheat","100", "Rp 1,500,000"),
                        listOf("Barley","100", "Rp 3,000,000"),
                        listOf("Sorghum","100", "Rp 4,000,000")
                    )
                )

            }
        }
    }
}

@Composable
fun InventarisContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(26.dp)
    ) {
        // Inventory Bahan Bibit Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Inventory Bahan Bibit",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF55AA68)
                )
                Spacer(modifier = Modifier.height(8.dp))
                ButtonText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Tambah Bahan Bibit",
                    onClick = { navController.navigate("input_bibit_screen") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Contoh tabel bahan bibit
                HistoryTable(
                    headers = listOf("Nama Bibit", "Stok (kg)", "Tanggal Masuk"),
                    rows = listOf(
                        listOf("Padi", "100", "2024-11-05"),
                        listOf("Jagung", "200", "2024-11-06"),
                        listOf("Wheat", "150", "2024-11-07"),
                        listOf("Barley", "250", "2024-11-08"),
                        listOf("Sorghum", "300", "2024-11-09")
                    )
                )
            }
        }

        // Inventory Bahan Baku Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Inventory Bahan Baku",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF55AA68)
                )
                Spacer(modifier = Modifier.height(8.dp))
                ButtonText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Tambah Bahan Baku",
                    onClick = { navController.navigate("input_bahan_baku_screen") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Contoh tabel bahan baku
                HistoryTable(
                    headers = listOf("Nama Bahan", "Stok (kg)", "Tanggal Masuk"),
                    rows = listOf(
                        listOf("Pupuk", "500", "2024-11-07"),
                        listOf("Pestisida", "300", "2024-11-08"),
                        listOf("Kapur", "100", "2024-11-09"),
                        listOf("Pupuk Organik", "200", "2024-11-10"),
                        listOf("Herbisida", "150", "2024-11-11")
                    )
                )
            }
        }
    }
}

@Composable
fun ExportButton(onClick: () -> Unit) {
    ButtonText(
        modifier = Modifier.fillMaxWidth(),
        text = "Export Data",
        onClick = onClick
    )
}

@Composable
fun HistoryTable(headers: List<String>, rows: List<List<String>>) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Table headers
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            headers.forEach { header ->
                Text(
                    text = header,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        // Table rows
        rows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                row.forEach { cell ->
                    Text(
                        text = cell,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}


