package com.example.tanimaster.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun UndoneTask() {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(300.dp)
            .height(150.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp)) // HANYA BARIS INI YANG DITAMBAHKAN (untuk bayangan)
            .background(Color.White, RoundedCornerShape(8.dp)) // Background tetap ada
            .padding(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "UNDONE", fontWeight = FontWeight.Bold, color = Color(0xFFBB4B4B))
                Text(text = "Project", fontWeight = FontWeight.Normal, color = Color.Gray)
            }
            Text(text = "Produktivitas Petani", fontWeight = FontWeight.SemiBold)
            Text(text = "14 Desember, 2024")
        }
    }
}