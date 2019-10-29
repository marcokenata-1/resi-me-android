package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.Home

import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val recipeRepository: RecipeRepository
) : ViewModel(), CoroutineScope {
    // TODO: Implement the ViewModel

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + Dispatchers.Main

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }



    init {
        launch {

        }
    }

}
