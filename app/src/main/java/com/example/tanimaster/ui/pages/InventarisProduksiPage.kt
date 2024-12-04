package com.example.tanimaster.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.TopAppBarDefaults.smallTopAppBarColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tanimaster.ui.components.ButtonText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventarisProduksiPage(modifier: Modifier = Modifier, navController: NavController) {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inventaris & Produksi", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                colors = smallTopAppBarColors(
                    containerColor = Color(0xFF55AA68),
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {

            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color(0xFFF5F5F5),
                contentColor = Color(0xFF55AA68)
            ) {
                Tab(
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 },
                    text = { Text("Inventaris", fontWeight = FontWeight.Bold) }
                )
                Tab(
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 },
                    text = { Text("Produksi", fontWeight = FontWeight.Bold) }
                )
            }

            // Content of the selected tab
            when (selectedTab) {
                0 -> InventarisTabContent(navController = navController)
                1 -> ProduksiTabContent(navController = navController)
            }
        }
    }
}

@Composable
fun InventarisTabContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ButtonText(
            text = "Inventory Bahan Bibit",
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* Navigate to Inventory Bahan Bibit Page */ }
        )
        ButtonText(
            text = "Inventory Bahan Baku",
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* Navigate to Inventory Bahan Baku Page */ }
        )
        ButtonText(
            text = "Export Data Inventory",
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* Export Inventory Data */ }
        )
    }
}

@Composable
fun ProduksiTabContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ButtonText(
            text = "Jumlah Penanaman",
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* Navigate to Jumlah Penanaman Page */ }
        )
        ButtonText(
            text = "Hasil Panen",
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* Navigate to Hasil Panen Page */ }
        )
        ButtonText(
            text = "Export Data Produksi",
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* Export Produksi Data */ }
        )
    }
}
