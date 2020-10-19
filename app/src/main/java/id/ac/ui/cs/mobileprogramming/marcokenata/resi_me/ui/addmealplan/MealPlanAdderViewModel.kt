package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.addmealplan

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.MealPlans
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.SavedRecipes
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MealPlanAdderViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    val savedRecipes = MutableLiveData<List<SavedRecipes>?>()

    init {
        launch {
            savedRecipes.postValue(recipeRepository.fetchSavedRecipesList().value)
        }
    }

    fun addMeal(mealPlans: MealPlans) {
        launch {
            recipeRepository.insertMealPlanRepo(mealPlans)
        }
    }
}
