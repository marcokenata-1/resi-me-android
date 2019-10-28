package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository

import androidx.lifecycle.LiveData
import dagger.Module
import dagger.Provides
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.MealPlans
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.RecipeDBDataSource
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.SavedRecipes
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.RecipeDataSource
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.Categories
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.CategoryParent
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.DataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Module
class RecipeRepository @Inject constructor(
    private val recipeDataSource: RecipeDataSource,
    private val recipeDBDataSource: RecipeDBDataSource
) {

    @Provides
    suspend fun fetchGetMealById(id : Int) : LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            recipeDataSource.getMealById(id)
            return@withContext recipeDataSource.mealById

        }
    }

    @Provides
    suspend fun fetchGetMealByRandom() : LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            recipeDataSource.getMealByRandom()
            return@withContext recipeDataSource.mealByRandom
        }
    }

    @Provides
    suspend fun fetchGetMealsByCategory(category : String) : LiveData<CategoryParent> {
        return withContext(Dispatchers.IO){
            recipeDataSource.getMealByCategory(category)
            return@withContext recipeDataSource.mealByCategory
        }
    }

    @Provides
    suspend fun insertSavedRecipesRepo(savedRecipes: SavedRecipes) {
        return withContext(Dispatchers.IO){
            recipeDBDataSource.insertSavedRecipes(savedRecipes)
        }
    }

    @Provides
    suspend fun insertMealPlanRepo(mealPlans: MealPlans){
        return withContext(Dispatchers.IO){
            recipeDBDataSource.insertMealPlan(mealPlans)
        }
    }

    @Provides
    suspend fun fetchSavedRecipeById(id: Int) : LiveData<SavedRecipes> {
        return withContext(Dispatchers.IO){
            recipeDBDataSource.displaySavedRecipes(id)
            return@withContext recipeDBDataSource.displaySavedRecipes
        }
    }

    @Provides
    suspend fun fetchCategories() : LiveData<Categories> {
        return withContext(Dispatchers.IO){
            recipeDataSource.getCategories()
            return@withContext recipeDataSource.categories
        }
    }
}