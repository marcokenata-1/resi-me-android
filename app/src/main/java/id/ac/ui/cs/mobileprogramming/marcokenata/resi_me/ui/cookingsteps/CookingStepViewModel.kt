package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.cookingsteps

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.Meals
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CookingStepViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val recipeLiveData = MutableLiveData<Meals>()

    fun getId(id: Int){
        launch {
            recipeLiveData.value = recipeRepository.fetchSavedRecipeByMeal(id).value?.meals
            if (recipeLiveData.value == null){
                recipeLiveData.value = recipeRepository.fetchGetMealById(id).value?.meals?.get(0)
            }
        }
    }

}
