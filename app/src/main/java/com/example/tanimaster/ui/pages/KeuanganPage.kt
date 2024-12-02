package com.example.tanimaster.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun KeuanganPage(modifier: Modifier = Modifier, navController: NavController) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        BoxKeuanganAnda(navController)

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "History Aktivitas Keuangan",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // History List dalam bentuk tabel (statis sementara)
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE0E0E0)),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("Tanggal", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                Text("Deskripsi", modifier = Modifier.weight(2f), textAlign = TextAlign.Center)
                Text("Jumlah", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
            }
            repeat(4) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Text("2024-11-25", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                    Text("Transaksi $index", modifier = Modifier.weight(2f), textAlign = TextAlign.Center)
                    Text("Rp ${index * 1000}", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button Input Modal
        Button(
            onClick = { navController.navigate("input_modal_screen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)) // Blue
        ) {
            Text(text = "Input Modal", color = Color.White)
        }
    }
}

@Composable
fun BoxKeuanganAnda(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Keuangan Anda",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Total Keuangan: Rp 10,000,000",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF388E3C)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    navController.navigate("input_modal_screen")
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)) // Blue
            ) {
                Text(text = "Input Modal", color = Color.White, textAlign = TextAlign.Center)
            }
            Button(
                onClick = { /* Handle Pengeluaran */ },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)) // Red
            ) {
                Text(text = "Pengeluaran", color = Color.White, textAlign = TextAlign.Center)
            }
        }
    }
}
