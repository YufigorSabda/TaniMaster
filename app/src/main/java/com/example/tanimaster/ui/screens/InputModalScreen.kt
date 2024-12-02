@file:Suppress("DEPRECATION")

package com.example.tanimaster.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.core.view.ViewCompat
import com.example.tanimaster.ui.components.ButtonText
import com.example.tanimaster.ui.components.CustomText
import androidx.compose.foundation.text.KeyboardOptions


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputModalScreen(modifier: Modifier = Modifier, navController: NavController) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        val windowInsetsController = ViewCompat.getWindowInsetsController(view)
        windowInsetsController?.isAppearanceLightStatusBars = false // false untuk ikon putih
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Input Modal Keuangan", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF55AA68),
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
        ContentScreen(modifier = Modifier.padding(innerPadding), navController = navController)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContentScreen(modifier: Modifier, navController: NavController) {
    var modalAmount by remember { mutableStateOf("") }  // Properti untuk jumlah modal
    var description by remember { mutableStateOf("") }  // Properti untuk deskripsi

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Modal Amount Input (Only Numbers)
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            CustomText("Jumlah Modal")
            // Menggunakan TextField dengan keyboardOptions untuk angka
            TextField(
                value = modalAmount,
                onValueChange = { newAmount ->
                    if (newAmount.all { it.isDigit() }) {  // Only allow digits
                        modalAmount = newAmount
                    }
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Masukkan jumlah modal") },
                singleLine = true
            )
        }

        // Description Input (Wider TextField)
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            CustomText("Deskripsi")
            TextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)  // Membuat kolom deskripsi lebih lebar ke bawah
                    .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(8.dp)),
                placeholder = { Text("Masukkan deskripsi...") },
                textStyle = MaterialTheme.typography.bodyLarge.copy(fontSize = 14.sp),
                maxLines = 5  // Allow multiline input for description
            )
        }

        // Action Button for Submit
        ButtonText(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Simpan"
        )

        // Cancel Action (Optional)
        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text("Batal")
        }
    }
}
