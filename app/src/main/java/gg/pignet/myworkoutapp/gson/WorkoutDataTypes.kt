package gg.pignet.myworkoutapp.gson

data class Exercise(
    val exercise_id: Int,
    val exercise_name: String,
    val exercise_thumbnail: String,
    val muscle_group: String,
    val muscle_group_image: String,
    val amount_of_sets: Int,
    val rep_range: String,
    val weight_amount: Double?
)

data class Workout(val day: Int, val workout: List<Exercise>)

data class Workouts(val workouts: List<Workout>) : Iterable<Workout> {
    override fun iterator(): Iterator<Workout> = workouts.iterator()
}