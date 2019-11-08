package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.mealplandisplay

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.MealPlans
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MealPlanDisplayViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    val mealPlanLiveData = MutableLiveData<MealPlans>()

    fun getPlan(id:Int) = launch {
        mealPlanLiveData.value = recipeRepository.fetchMealPlan(id).value
    }
}
