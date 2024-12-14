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
fun Task() {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(300.dp)
            .height(150.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "DONE", fontWeight = FontWeight.Bold, color = Color(0xFF55AA68))
                Text(text = "Tugas", fontWeight = FontWeight.Normal, color = Color.Gray)
            }
            Text(text = "Kelola Irigasi", fontWeight = FontWeight.SemiBold)
            Text(text = "13 Desember, 2024")
        }
    }
}