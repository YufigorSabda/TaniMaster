@file:Suppress("DEPRECATION")

package com.example.tanimaster.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.navigation.NavController
import com.example.tanimaster.ui.components.CustomText
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputKeuanganScreen(modifier: Modifier = Modifier, navController: NavController) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        val windowInsetsController = ViewCompat.getWindowInsetsController(view)
        windowInsetsController?.isAppearanceLightStatusBars = false
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Input Data Keuangan", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF55AA68),
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali", tint = Color.White)
                    }
                }
            )
        }
    ) { innerPadding ->
        ContentKeuanganScreen(modifier = Modifier.padding(innerPadding), navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ContentKeuanganScreen(modifier: Modifier = Modifier, navController: NavController) {
    var selectedDate by remember { mutableStateOf("") } // Properti untuk tanggal
    var modalAmount by remember { mutableStateOf("") } // Properti untuk jumlah modal
    var description by remember { mutableStateOf("") } // Properti untuk deskripsi
    var mitra by remember { mutableStateOf("") } // Properti untuk mitra
    val selectedCategory = remember { mutableStateOf<String?>(null) } // Properti kategori terpilih

    val categories = listOf(
        "Modal", "Pengeluaran", "Pinjaman",
        "Pendapatan", "Lainnya"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input Tanggal
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Tanggal")
            OutlinedTextField(
                value = selectedDate,
                onValueChange = { selectedDate = it },
                placeholder = { Text("Pilih Tanggal") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF7F7F7),
                    focusedBorderColor = Color(0xFF55AA68),
                    unfocusedBorderColor = Color(0xFFD3D3D3)
                )
            )
        }

        // Input Kategori Modal
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Tipe Kategori")
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                categories.forEach { category ->
                    val isSelected = selectedCategory.value == category
                    Button(
                        onClick = { selectedCategory.value = category },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSelected) Color(0xFF55AA68) else Color(0xFFE0E0E0),
                            contentColor = if (isSelected) Color.White else Color.Black
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(category)
                    }
                }
            }
        }

        // Input Nominal
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Input Nominal")
            OutlinedTextField(
                value = modalAmount,
                onValueChange = { newAmount ->
                    // Memastikan hanya angka yang dimasukkan
                    // Menjaga agar input hanya berupa angka atau tanda koma/ titik untuk desimal
                    if (newAmount.isEmpty() || newAmount.all { it.isDigit() || it == '.' || it == ',' }) {
                        modalAmount = newAmount
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                placeholder = { Text("Masukkan Nominal") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF7F7F7),
                    focusedBorderColor = Color(0xFF55AA68),
                    unfocusedBorderColor = Color(0xFFD3D3D3)
                )
            )
        }

        // Input Mitra
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Mitra")
            OutlinedTextField(
                value = mitra,
                onValueChange = { mitra = it },
                placeholder = { Text("Masukkan Mitra") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF7F7F7),
                    focusedBorderColor = Color(0xFF55AA68),
                    unfocusedBorderColor = Color(0xFFD3D3D3)
                )
            )
        }

        // Tombol Aksi (Simpan dan Batal)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            // Tombol Simpan
            Button(
                onClick = {
                    // Parse modalAmount to numeric value if needed
                    val amount = modalAmount.replace(",", ".").toDoubleOrNull() ?: 0.0
                    // Tambahkan aksi simpan dengan selectedDate, selectedCategory, amount, description, and mitra
                },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF55AA68))
            ) {
                Text("Simpan", color = Color.White)
            }

            // Tombol Batal
            OutlinedButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFF55AA68)),
                border = BorderStroke(1.dp, Color(0xFF55AA68))
            ) {
                Text("Batal")
            }
        }
    }
}
