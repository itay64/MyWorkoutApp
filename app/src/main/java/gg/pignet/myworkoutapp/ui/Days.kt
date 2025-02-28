package gg.pignet.myworkoutapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gg.pignet.myworkoutapp.MainActivity
import gg.pignet.myworkoutapp.color.BlueTextColor
import gg.pignet.myworkoutapp.color.DaysNotClickedOn
import gg.pignet.myworkoutapp.color.SecondaryColor
import gg.pignet.myworkoutapp.gson.Exercise
import gg.pignet.myworkoutapp.gson.JsonHandler
import gg.pignet.myworkoutapp.gson.Workouts

@Composable
fun Days( activity: MainActivity){

    var currentWorkout: List<Exercise> by remember { mutableStateOf(listOf()) }
    var workouts by remember { mutableStateOf<Workouts?>(null) }
    var clickedDay by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        JsonHandler.loadWorkouts(activity)?.let {
            workouts = it
            it.workouts.firstOrNull()?.workout?.let { currentWorkout = it }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Transparent)
            .offset(y = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(6.dp)
        ){
            val days = workouts?.workouts?.map { it.day } ?: listOf(1, 2, 3 , 4)
            days.forEachIndexed { index, day ->
                Button(
                    {
                        clickedDay = index
                        workouts?.let { workouts -> workouts.workouts.firstOrNull { it.day == day }?.workout?.let { currentWorkout = it } }
                    },
                    modifier = Modifier.height(48.dp).width(76.dp).padding(horizontal = 2.dp),
                    shape = RoundedCornerShape(32.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = if (clickedDay == index) SecondaryColor else DaysNotClickedOn),
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Day $day",
                        fontSize = 12.5.sp,
                        fontWeight = FontWeight.Medium,
                        color = BlueTextColor,
                        letterSpacing = 0.1.sp,
                        maxLines = 1,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(32.dp))
    WeekAndUpComingWorkoutTitle()
    Spacer(modifier = Modifier.height(16.dp))
    WorkoutContent(currentWorkout, activity)

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FloatingActionButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text(
                text = "+",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }

}