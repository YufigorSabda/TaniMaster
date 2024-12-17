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
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputHasilPanenScreen(modifier: Modifier = Modifier, navController: NavController) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        val windowInsetsController = ViewCompat.getWindowInsetsController(view)
        windowInsetsController?.isAppearanceLightStatusBars = false
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Input Hasil Panen", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
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
        ContentHasilPanenScreen(modifier = Modifier.padding(innerPadding), navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHasilPanenScreen(modifier: Modifier, navController: NavController) {
    var jenisTumbuhan by remember { mutableStateOf("") } // Properti untuk jenis tumbuhan
    var jumlah by remember { mutableStateOf("") } // Properti untuk jumlah (kg)
    var hargaJual by remember { mutableStateOf("") } // Properti untuk harga jual

    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val currentDate = dateFormat.format(Date())

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input Jenis Tumbuhan
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Jenis Tumbuhan")
            OutlinedTextField(
                value = jenisTumbuhan,
                onValueChange = { jenisTumbuhan = it },
                placeholder = { Text("Masukkan jenis tumbuhan") },
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

        // Input Jumlah (Kg)
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Jumlah (Kg)")
            OutlinedTextField(
                value = jumlah,
                onValueChange = { newJumlah ->
                    if (newJumlah.all { it.isDigit() }) {
                        jumlah = newJumlah
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                placeholder = { Text("Masukkan jumlah dalam kg") },
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

        // Input Harga Jual
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Harga Jual")
            OutlinedTextField(
                value = hargaJual,
                onValueChange = { hargaJual = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                placeholder = { Text("Masukkan harga jual total") },
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
                    // Tambahkan aksi simpan
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
