package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db

import androidx.room.Database


@Database(
    entities = [SavedRecipes::class,MealPlans::class],
    version = 2,
    exportSchema = false
)
abstract class RecipeDatabase {
    abstract fun recipeDao() : RecipeDao
}