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

    private val _displaySavedRecipe = MutableLiveData<SavedRecipes>()

    val displaySavedRecipes : LiveData<SavedRecipes>
        get() = _displaySavedRecipe

    private val _displaySavedRecipeList = MutableLiveData<List<SavedRecipes>>()

    val displaySavedRecipesList : LiveData<List<SavedRecipes>>
        get() = _displaySavedRecipeList

    private val _displayMealPlanList = MutableLiveData<List<MealPlans>>()

    val displayMealPlanList : LiveData<List<MealPlans>>
        get() = _displayMealPlanList

    @Provides
    suspend fun insertSavedRecipe(savedRecipes: SavedRecipes){
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
    suspend fun displaySavedRecipe(id: Int){
        return withContext(Dispatchers.IO){
            _displaySavedRecipe.postValue(recipeDao.displayRecipe(id))
        }
    }

    @Provides
    suspend fun displaySavedRecipesList(){
        return withContext(Dispatchers.IO){
            _displaySavedRecipeList.postValue(recipeDao.displayRecipeList())
        }
    }

    @Provides
    suspend fun displayMealPlanList(){
        return withContext(Dispatchers.IO){
            _displayMealPlanList.postValue(recipeDao.displayMealPlanList())
        }
    }
}