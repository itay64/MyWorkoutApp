package gg.pignet.myworkoutapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gg.pignet.myworkoutapp.R
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
                .padding(6.dp)
        ) {
            val items = listOf(
                "Muscles (16)", "45-60 Min", "Schedule",
                "Basic Exercises", "Equipment (64)", "Goals (1)", "Refresh Plan"
            )

            items.forEach { text ->
                val color = Color.White
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .background(SecondaryColor, shape = RoundedCornerShape(32.dp))
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = text,
                        fontSize = 13.sp,
                        color = color,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.width(6.dp))
                    Icon(painter = painterResource(R.drawable.chevron_down), null, tint = color, modifier = Modifier.size(15.dp))
                }
            }
        }
    }
}
