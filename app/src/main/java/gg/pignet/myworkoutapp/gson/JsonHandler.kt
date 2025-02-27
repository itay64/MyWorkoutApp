package gg.pignet.myworkoutapp.gson

import android.content.Context
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object JsonHandler {
    private const val WORKOUTS_FILE_NAME = "workouts.json"
    private val GSON = GsonBuilder().setPrettyPrinting().create()
    suspend fun loadWorkouts(context: Context): Workouts? = withContext(Dispatchers.IO) {
        try {
            GSON.fromJson(context.assets.open(WORKOUTS_FILE_NAME).bufferedReader().use { it.readText() }, Workouts::class.java)
        } catch (e: Exception){
            e.printStackTrace()
            null
        }
    }
}