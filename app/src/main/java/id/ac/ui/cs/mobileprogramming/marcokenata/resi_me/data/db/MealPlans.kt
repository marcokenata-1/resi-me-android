package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.Meals

@Entity(tableName = "meal_plans")
data class MealPlans(
    val mealPlanName: String,
    val meals: ArrayList<Meals?>
){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}