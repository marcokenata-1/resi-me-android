package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSavedRecipes(savedRecipes: SavedRecipes)

    @Query("select * from saved_recipes where mealId = id")
    fun displayRecipe(id: Int) : SavedRecipes

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMealPlan(mealPlans: MealPlans)


}