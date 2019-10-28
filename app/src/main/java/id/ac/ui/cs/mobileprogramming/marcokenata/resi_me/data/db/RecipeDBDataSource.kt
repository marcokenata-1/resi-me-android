package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeDBDataSource constructor(private val recipeDao: RecipeDao) {

    private val _displaySavedRecipes = MutableLiveData<SavedRecipes>()

    val displaySavedRecipes : LiveData<SavedRecipes>
        get() = _displaySavedRecipes

    suspend fun insertSavedRecipes(savedRecipes: SavedRecipes){
        return withContext(Dispatchers.IO){
            recipeDao.insertSavedRecipes(savedRecipes)
        }
    }

    suspend fun insertMealPlan(mealPlans: MealPlans){
        return withContext(Dispatchers.IO){
            recipeDao.insertMealPlan(mealPlans)
        }
    }

    suspend fun displaySavedRecipes(id: Int){
        return withContext(Dispatchers.IO){
            _displaySavedRecipes.postValue(recipeDao.displayRecipe(id))
        }
    }
}