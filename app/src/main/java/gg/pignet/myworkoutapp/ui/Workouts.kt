package gg.pignet.myworkoutapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gg.pignet.myworkoutapp.color.SecondaryColor
import gg.pignet.myworkoutapp.gson.Workouts

@Composable
fun Workouts(workouts: Workouts?) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(SecondaryColor)
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Row {
                Text(workouts?.firstOrNull()?.workout?.firstOrNull()?.exercise_name ?: "No Exercise")
            }
        }
    }
}

