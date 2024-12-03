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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PengeluaranScreen(modifier: Modifier = Modifier, navController: NavController) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        val windowInsetsController = ViewCompat.getWindowInsetsController(view)
        windowInsetsController?.isAppearanceLightStatusBars = false // Ikon putih di status bar
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Input Pengeluaran Keuangan", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF55AA68), // Hijau
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali", tint = Color.White)
                    }
                }
            )
        }
    ) { innerPadding ->
        PengeluaranContent(
            modifier = Modifier.padding(innerPadding),
            navController = navController
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PengeluaranContent(modifier: Modifier, navController: NavController) {
    var pengeluaranAmount by remember { mutableStateOf("") } // Properti untuk jumlah pengeluaran
    var description by remember { mutableStateOf("") }      // Properti untuk deskripsi

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input Jumlah Pengeluaran
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Jumlah Pengeluaran")
            OutlinedTextField(
                value = pengeluaranAmount,
                onValueChange = { newAmount ->
                    if (newAmount.all { it.isDigit() }) { // Hanya angka yang diperbolehkan
                        pengeluaranAmount = newAmount
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                placeholder = { Text("Masukkan jumlah pengeluaran") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF7F7F7),
                    focusedBorderColor = Color(0xFF55AA68), // Hijau saat fokus
                    unfocusedBorderColor = Color(0xFFD3D3D3),
                )
            )
        }

        // Input Deskripsi Pengeluaran
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Deskripsi")
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                placeholder = { Text("Masukkan deskripsi...") },
                maxLines = 5,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color(0xFFF7F7F7),
                    focusedBorderColor = Color(0xFF55AA68), // Hijau saat fokus
                    unfocusedBorderColor = Color(0xFFD3D3D3),
                )
            )
        }

        // Action Buttons (Simpan dan Batal)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
        ) {
            // Tombol Simpan
            Button(
                onClick = { /* Tambahkan aksi simpan */ },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF55AA68) // Hijau
                )
            ) {
                Text("Simpan", color = Color.White)
            }

            // Tombol Batal
            OutlinedButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFF55AA68) // Hijau
                ),
                border = BorderStroke(1.dp, Color(0xFF55AA68))
            ) {
                Text("Batal")
            }
        }
    }
}
