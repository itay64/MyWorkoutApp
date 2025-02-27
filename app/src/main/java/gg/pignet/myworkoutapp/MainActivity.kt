package gg.pignet.myworkoutapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gg.pignet.myworkoutapp.color.BackgroundColor
import gg.pignet.myworkoutapp.gson.JsonHandler
import gg.pignet.myworkoutapp.gson.Workouts
import gg.pignet.myworkoutapp.ui.Days
import gg.pignet.myworkoutapp.ui.TopScrollbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
        }
    }


}
