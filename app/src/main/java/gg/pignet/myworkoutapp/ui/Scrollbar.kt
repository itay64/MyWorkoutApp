package gg.pignet.myworkoutapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gg.pignet.myworkoutapp.color.SecondaryColor

@Composable
fun TopScrollbar() {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.Transparent)
            .offset(y = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(8.dp)
        ) {
            val items = listOf(
                "Muscles (16)", "45-60 Min", "Schedule",
                "Basic Exercises", "Equipment (64)", "Goals (1)", "Refresh Plan"
            )

            items.forEach { text ->
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(horizontal = 6.dp)
                        .background(SecondaryColor, shape = RoundedCornerShape(16.dp))
                        .padding(8.dp),
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
