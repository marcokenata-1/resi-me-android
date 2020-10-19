package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.congratulations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.SavedRecipes
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.Meals
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CongratulationsViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    var saved = "tidak"

    val recipeLiveData = MutableLiveData<Meals>()

    private val recipeChecker = MutableLiveData<Meals>()

    fun getId(id: Int){
        launch {
            recipeLiveData.value = recipeRepository.fetchSavedRecipeByMeal(id).value?.meals
            if (recipeLiveData.value == null){
                recipeLiveData.value = recipeRepository.fetchGetMealById(id).value?.meals?.get(0)
            }
            recipeChecker.value = recipeRepository.fetchSavedRecipeByMeal(id).value?.meals
            recipeSaved()
        }
    }

    fun saveRecipe(id: Int){
        launch {
            recipeRepository.insertSavedRecipesRepo(SavedRecipes(id,recipeLiveData.value))
        }
    }

    private fun recipeSaved(){
        if (recipeChecker.value == null) {
            saved = "tidak"
        } else {
            saved = "iya"
        }
    }
}
