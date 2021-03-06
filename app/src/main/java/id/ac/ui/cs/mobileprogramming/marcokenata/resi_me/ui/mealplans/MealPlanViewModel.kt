package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.mealplans

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.MealPlans
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MealPlanViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val mealPlanLiveData = MutableLiveData<List<MealPlans>?>()

    init {
        launch {
            mealPlanLiveData.postValue(recipeRepository.fetchMealPlanList().value)
        }
    }

}

