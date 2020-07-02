package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.savedrecipes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.db.SavedRecipes
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class SavedMenuViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel(), CoroutineScope {


    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    val savedRecipes = MutableLiveData<List<SavedRecipes>?>()

    init {
        launch {
            savedRecipes.postValue(recipeRepository.fetchSavedRecipesList().value)
        }
    }
}
