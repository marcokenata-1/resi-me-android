package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.Meals

@Entity(tableName = "saved_recipes")
data class SavedRecipes (
    val idMeal : Int,
    val meals: Meals?
){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}