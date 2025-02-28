package gg.pignet.myworkoutapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import gg.pignet.myworkoutapp.R
import gg.pignet.myworkoutapp.color.SecondaryColor

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        NavItem("My Workout", R.drawable.workout, "workout"),
        NavItem("Exercises", R.drawable.exercises, "exercises"),
        NavItem("Progress", R.drawable.progress, "progress"),
        NavItem("Settings", R.drawable.settings, "settings")
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    BottomNavigation(
        backgroundColor = SecondaryColor,
        contentColor = Color.White,
        elevation = 8.dp
    ) {
        items.forEach { item ->
            val selected = currentRoute == item.route

            BottomNavigationItem(
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.label,
                            modifier = Modifier.size(16.dp),
                            tint = if (selected) Color.Yellow else Color.White
                        )
                        Text(
                            text = item.label,
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.Bold,
                            color = if (selected) Color.Yellow else Color.Gray,
                            fontSize = 10.sp,
                        )
                    }
                },
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

private data class NavItem(val label: String, val icon: Int, val route: String)
