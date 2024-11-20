package com.example.tanimaster.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tanimaster.R


sealed class BottomNavItem(val route: String, val icon: Int, val title: String) {
    data object Home : BottomNavItem("home", R.drawable.ic_home,"Home")
    data object TaskList : BottomNavItem("tasklist", R.drawable.ic_tasklist,"Task List")
//    data object AddTask
    data object Calendar : BottomNavItem("calendar", R.drawable.ic_calendar, "Calendar")
    data object Profile : BottomNavItem("profile", R.drawable.ic_profile, "Profile")
}

@Composable
fun BottomAppBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.TaskList,
//        BottomNavItem.AddTask,
        BottomNavItem.Calendar,
        BottomNavItem.Profile
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar (
        containerColor = Color(0xffF5F5F7),
        contentColor = Color.White,
        modifier = Modifier
            .padding(horizontal =  8.dp)
    ){
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Image(
                        contentScale = ContentScale.Crop,
                        painter = painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(30.dp)
                    )
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
        }
    }
}