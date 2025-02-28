package gg.pignet.myworkoutapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gg.pignet.myworkoutapp.R
import gg.pignet.myworkoutapp.color.BlueTextColor
import gg.pignet.myworkoutapp.color.SecondaryColor

@Composable
fun WeekAndUpComingWorkoutTitle() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        Text(
            text = "Week 1/5 - Foundations",
            color = BlueTextColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "UPCOMING WORKOUT",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.align(Alignment.Center)
            )

            // Spacer to push the icon to the right
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                painter = painterResource(R.drawable.pencil),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterEnd) // This makes the icon go to the right side
                    .background(SecondaryColor, RoundedCornerShape(12.dp))
                    .size(40.dp),
                tint = Color.White
            )
        }

        Text(
            text = "Push",
            color = Color.LightGray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Black,
        )
    }
}
