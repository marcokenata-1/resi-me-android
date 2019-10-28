package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Module
class RecipeDBDataSource @Inject constructor(private val recipeDao: RecipeDao) {

    private val _displaySavedRecipes = MutableLiveData<SavedRecipes>()

    val displaySavedRecipes : LiveData<SavedRecipes>
        get() = _displaySavedRecipes

    @Provides
    suspend fun insertSavedRecipes(savedRecipes: SavedRecipes){
        return withContext(Dispatchers.IO){
            recipeDao.insertSavedRecipes(savedRecipes)
        }
    }

    @Provides
    suspend fun insertMealPlan(mealPlans: MealPlans){
        return withContext(Dispatchers.IO){
            recipeDao.insertMealPlan(mealPlans)
        }
    }

    @Provides
    suspend fun displaySavedRecipes(id: Int){
        return withContext(Dispatchers.IO){
            _displaySavedRecipes.postValue(recipeDao.displayRecipe(id))
        }
    }
}