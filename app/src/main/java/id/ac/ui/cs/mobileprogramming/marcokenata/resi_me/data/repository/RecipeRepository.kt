package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository

import androidx.lifecycle.LiveData
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.MealPlans
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.RecipeDBDataSource
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.SavedRecipes
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.RecipeDataSource
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.CategoryParent
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.DataResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RecipeRepository constructor(
    private val recipeDataSource: RecipeDataSource,
    private val recipeDBDataSource: RecipeDBDataSource
) {

    suspend fun fetchGetMealById(id : Int) : LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            recipeDataSource.getMealById(id)
            return@withContext recipeDataSource.mealById

        }
    }

    suspend fun fetchGetMealByRandom() : LiveData<DataResponse> {
        return withContext(Dispatchers.IO){
            recipeDataSource.getMealByRandom()
            return@withContext recipeDataSource.mealByRandom
        }
    }

    suspend fun fetchGetMealsByCategory(category : String) : LiveData<CategoryParent> {
        return withContext(Dispatchers.IO){
            recipeDataSource.getMealByCategory(category)
            return@withContext recipeDataSource.mealByCategory
        }
    }

    suspend fun insertSavedRecipesRepo(savedRecipes: SavedRecipes) {
        return withContext(Dispatchers.IO){
            recipeDBDataSource.insertSavedRecipes(savedRecipes)
        }
    }

    suspend fun insertMealPlanRepo(mealPlans: MealPlans){
        return withContext(Dispatchers.IO){
            recipeDBDataSource.insertMealPlan(mealPlans)
        }
    }

    suspend fun fetchSavedRecipeById(id: Int) : LiveData<SavedRecipes> {
        return withContext(Dispatchers.IO){
            recipeDBDataSource.displaySavedRecipes(id)
            return@withContext recipeDBDataSource.displaySavedRecipes
        }
    }
}