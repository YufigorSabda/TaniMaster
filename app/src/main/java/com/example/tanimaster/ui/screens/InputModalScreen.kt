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

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputModalScreen(modifier: Modifier = Modifier, navController: NavController) {
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
        ContentScreen(modifier = Modifier.padding(innerPadding), navController = navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ContentScreen(modifier: Modifier, navController: NavController) {
    var modalAmount by remember { mutableStateOf("") } // Properti untuk jumlah modal
    var description by remember { mutableStateOf("") } // Properti untuk deskripsi
    val selectedCategory = remember { mutableStateOf("") } // Properti kategori terpilih

    val categories = listOf(
        "Modal", "Pengeluaran", "Pinjaman",
        "Pendapatan","Lainnya"
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Input Jumlah Modal
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Input Nominal")
            OutlinedTextField(
                value = modalAmount,
                onValueChange = { newAmount ->
                    if (newAmount.all { it.isDigit() }) {
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



        // Input Deskripsi Modal
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
                    focusedBorderColor = Color(0xFF55AA68),
                    unfocusedBorderColor = Color(0xFFD3D3D3)
                )
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CustomText("Kategori")
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

        // Tombol Aksi (Simpan dan Batal)
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
