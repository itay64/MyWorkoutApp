package gg.pignet.myworkoutapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gg.pignet.myworkoutapp.MainActivity
import gg.pignet.myworkoutapp.R
import gg.pignet.myworkoutapp.color.SecondaryColor
import gg.pignet.myworkoutapp.gson.Exercise

@Composable
fun WorkoutContent(exercises: List<Exercise>, activity: MainActivity) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(SecondaryColor, RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy((-12).dp)
        ) {
            item { ExerciseAmountTimeAndCalories(exercises.size) }
            item { Spacer(Modifier.height(32.dp)) }
            items(exercises) { exercise ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(2.dp)
                        .heightIn(min = 80.dp),
                    shape = RoundedCornerShape(32.dp),
                    elevation = 0.dp,
                    backgroundColor = SecondaryColor
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(SecondaryColor)
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        val resId = getDrawableResId(imageName = exercise.exercise_thumbnail)
                        if (resId != 0) {
                            Image(
                                painter = painterResource(id = resId),
                                contentDescription = null,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))  // First clip
                                    .size(74.dp)  // Then size
                                    .background(Color.Transparent)  // Ensure no extra background issues
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(Modifier.weight(1.0F).fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy((-2).dp)
                        ) {
                            Text(
                                text = exercise.exercise_name,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                style = TextStyle(lineHeight = 16.sp)
                            )
                            val weightText = if (exercise.weight_amount == null)
                                "${exercise.amount_of_sets} sets x ${exercise.rep_range}"
                            else
                                "${exercise.amount_of_sets} sets x ${exercise.rep_range} x ${formatDouble(exercise.weight_amount)} lb"
                            Text(text = weightText, fontSize = 14.sp, color = Color.LightGray)
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        val muscleGroupResId = getDrawableResId(exercise.muscle_group_image)
                        if (muscleGroupResId != 0) {
                            Image(
                                painter = painterResource(id = muscleGroupResId),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(androidx.compose.foundation.shape.CircleShape)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun ExerciseAmountTimeAndCalories(exerciseAmount: Int){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        shape = RoundedCornerShape(32.dp),
        elevation = 0.dp,
        backgroundColor = SecondaryColor
    ){
        Row(
            modifier = Modifier.offset(y = 6.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(getDrawableResId("workout_exercise_amount")),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "$exerciseAmount Exercises",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.width(8.dp))
            Image(
                painter = painterResource(getDrawableResId("workout_time")),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(2.dp))
            Text(
                text = "${exerciseAmount * 9} Min",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(Modifier.width(8.dp))
            Image(
                painter = painterResource(getDrawableResId("workout_calories")),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(2.dp))
            Text(
                text = "${exerciseAmount * 45} cal",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

private fun getDrawableResId(imageName: String): Int {
    return when (imageName) {
        "exc_t_150_ronald" -> R.drawable.exc_t_150_ronald
        "exc_t_151_ronald" -> R.drawable.exc_t_151_ronald
        "exc_t_153_ronald" -> R.drawable.exc_t_153_ronald
        "exc_t_154_ronald" -> R.drawable.exc_t_154_ronald
        "exc_t_155_ronald" -> R.drawable.exc_t_155_ronald
        "exc_t_156_ronald" -> R.drawable.exc_t_156_ronald
        "exc_t_157_ronald" -> R.drawable.exc_t_157_ronald
        "exc_t_159_ronald" -> R.drawable.exc_t_159_ronald
        "exc_t_161_ronald" -> R.drawable.exc_t_161_ronald
        "exc_t_162_ronald" -> R.drawable.exc_t_162_ronald
        "exc_t_163_ronald" -> R.drawable.exc_t_163_ronald
        "exc_t_166_ronald" -> R.drawable.exc_t_166_ronald
        "exc_t_167_ronald" -> R.drawable.exc_t_167_ronald
        "Muscle Groups 1" -> R.drawable.muscle_groups_1
        "Muscle Groups 2" -> R.drawable.muscle_groups_2
        "Muscle Groups 3" -> R.drawable.muscle_groups_3
        "Muscle Groups 4" -> R.drawable.muscle_groups_4
        "Muscle Groups 5" -> R.drawable.muscle_groups_5
        "workout_calories" -> R.drawable.workout_calories
        "workout_exercise_amount" -> R.drawable.workout_exercise_amount
        "workout_time" -> R.drawable.workout_time
        else -> R.drawable.exc_t_168_ronald
    }
}

private fun formatDouble(value: Double): String {
    return if (value % 1.0 == 0.0) {
        value.toInt().toString()
    } else {
        value.toString()
    }
}