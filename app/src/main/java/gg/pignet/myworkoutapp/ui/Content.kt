package gg.pignet.myworkoutapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gg.pignet.myworkoutapp.MainActivity
import gg.pignet.myworkoutapp.R
import gg.pignet.myworkoutapp.color.SecondaryColor
import gg.pignet.myworkoutapp.gson.Exercise

@Composable
fun WorkoutContent(exercises: List<Exercise>, activity: MainActivity){
    LazyColumn(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(exercises){ exercise ->


            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(100.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = 4.dp
            ){
                Row(
                    modifier = Modifier.fillMaxSize()
                        .background(SecondaryColor)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val resId = getDrawableResId(imageName = exercise.exercise_thumbnail)
                    if (resId != 0) {
                        Image(
                            painter = painterResource(id = resId),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(RoundedCornerShape(8.dp))
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))

                    Column {
                        Text(text = exercise.exercise_name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                        val weightText = if (exercise.weight_amount == null) "${exercise.amount_of_sets} sets x ${exercise.rep_range}" else "${exercise.amount_of_sets} sets x ${exercise.rep_range} x ${formatDouble(exercise.weight_amount)} lb"
                        Text(text = weightText, fontSize = 14.sp, color = Color.Gray)
                    }

                }
            }
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