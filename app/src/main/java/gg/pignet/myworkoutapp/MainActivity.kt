package gg.pignet.myworkoutapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import gg.pignet.myworkoutapp.color.BackgroundColor
import gg.pignet.myworkoutapp.color.SecondaryColor
import gg.pignet.myworkoutapp.ui.BottomNavBar
import gg.pignet.myworkoutapp.ui.Days
import gg.pignet.myworkoutapp.ui.ExercisesScreen
import gg.pignet.myworkoutapp.ui.ProgressScreen
import gg.pignet.myworkoutapp.ui.SettingsScreen
import gg.pignet.myworkoutapp.ui.StartWorkoutButton
import gg.pignet.myworkoutapp.ui.TopScrollbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackgroundColor
                ) {
                    MainScreen()
                }
            }
        }
        /*
                    MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BackgroundColor
                ) {}
                Column(modifier = Modifier.fillMaxSize()) {
                    TopScrollbar()
                    Spacer(modifier = Modifier.height(16.dp))
                    Days(this@MainActivity)
                }
            }
         */
    }


    @Composable
    fun MainScreen() {
        val navController = rememberNavController()

        Scaffold(
            backgroundColor = BackgroundColor,
            bottomBar = { BottomNavBar(navController) },
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = "workout"
                ) {
                    composable("workout") { WorkoutScreen() }
                    composable("exercises") { ExercisesScreen() }
                    composable("progress") { ProgressScreen() }
                    composable("settings") { SettingsScreen() }
                }
            }
        }
    }

    @Composable
    fun WorkoutScreen() {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                TopScrollbar()
                Spacer(modifier = Modifier.height(16.dp))
                Days(this@MainActivity)
                Spacer(modifier = Modifier.weight(1f))
            }
            StartWorkoutButton(
                modifier = Modifier
                    .align(Alignment.Center)
                    .offset(y = (256+64).dp)
            )
        }
    }


}
