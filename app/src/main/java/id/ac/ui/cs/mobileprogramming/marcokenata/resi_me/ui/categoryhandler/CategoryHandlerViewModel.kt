package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.categoryhandler

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.network.response.CategoryParent
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CategoryHandlerViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel(), CoroutineScope {


    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val categoryLiveData = MutableLiveData<CategoryParent>()

    fun getCategory(category: String){
        launch {
            categoryLiveData.value = recipeRepository.fetchGetMealsByCategory(category).value
        }
    }
}
