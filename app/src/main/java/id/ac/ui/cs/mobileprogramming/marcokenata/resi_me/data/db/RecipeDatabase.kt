package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [SavedRecipes::class,MealPlans::class],
    version = 2,
    exportSchema = false
)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao() : RecipeDao
}