package gg.pignet.myworkoutapp.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gg.pignet.myworkoutapp.MainActivity
import gg.pignet.myworkoutapp.color.BlueTextColor
import gg.pignet.myworkoutapp.color.SecondaryColor
import gg.pignet.myworkoutapp.gson.Workouts

@Composable
fun Days(workouts: Workouts?, activity: MainActivity){
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
            days.forEach { day ->
                Button(
                    {
                        Toast.makeText(activity, "You have clicked on Day $day", Toast.LENGTH_LONG).show()
                    },
                    modifier = Modifier.height(44.dp).width(88.dp).padding(horizontal = 2.dp),
                    shape = RoundedCornerShape(32.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = SecondaryColor),
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Day $day",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = BlueTextColor,
                        letterSpacing = 0.5.sp,
                        maxLines = 1,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}