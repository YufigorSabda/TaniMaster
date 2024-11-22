package com.example.tanimaster.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tanimaster.R
import com.example.tanimaster.ui.components.BottomAppBar

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold (
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        bottomBar = {
            if (navController != null) {
                BottomAppBar(navController=navController)
            }
        },
        content = { padding ->
            Column (
                modifier = Modifier
                    .background(color = Color(0xFFDAEBD1))
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box (
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.White, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Profile Picture",
                        modifier = Modifier.size(64.dp),
                        tint = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Sigma Farm",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color =  Color.Black
                )

//                Box(
//                    modifier = Modifier
//                        .width(378.dp)
//                        .height(323.dp)
//                        .background(Color.White),
//                    contentAlignment = Alignment.Center,
//                ){
//                    MenuItem(icon = ImageVector.vectorResource(id = R.drawable.ic_tasklist), label = "My Task")
//                }
            }

        }
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}