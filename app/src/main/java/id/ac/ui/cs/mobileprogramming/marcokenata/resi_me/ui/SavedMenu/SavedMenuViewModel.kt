package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.SavedMenu

import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
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
}
