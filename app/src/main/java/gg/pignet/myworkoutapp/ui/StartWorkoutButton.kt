package gg.pignet.myworkoutapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gg.pignet.myworkoutapp.color.GradientFirst
import gg.pignet.myworkoutapp.color.GradientSecond

@Composable
fun StartWorkoutButton(
    modifier: Modifier = Modifier
) {

    val gradient = Brush.verticalGradient(colors = listOf(GradientFirst, GradientSecond))

    Button(
        onClick = {},
        modifier = modifier
            .width(344.dp)
            .height(72.dp)
            .background(gradient, RoundedCornerShape(12.dp)),
        elevation = null,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
    ) {
        Text(
            text = "START WORKOUT",
            maxLines = 1,
            color = Color.Black,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 0.1.sp
        )
    }
}
