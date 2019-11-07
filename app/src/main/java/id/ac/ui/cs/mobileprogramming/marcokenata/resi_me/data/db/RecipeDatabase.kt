package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.converters.Converters


@Database(
    entities = [SavedRecipes::class,MealPlans::class],
    version = 8,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao() : RecipeDao
}