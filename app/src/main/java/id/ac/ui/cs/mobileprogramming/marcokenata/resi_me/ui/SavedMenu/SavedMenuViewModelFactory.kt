package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.SavedMenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import javax.inject.Inject

@Module
class SavedMenuViewModelFactory @Inject constructor(private val recipeRepository: RecipeRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SavedMenuViewModel(recipeRepository) as T
    }

}