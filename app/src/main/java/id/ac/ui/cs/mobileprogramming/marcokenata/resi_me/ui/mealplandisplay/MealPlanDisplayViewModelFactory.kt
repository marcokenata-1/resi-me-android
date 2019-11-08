package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.mealplandisplay

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import javax.inject.Inject

@Module
class MealPlanDisplayViewModelFactory @Inject constructor(private val recipeRepository: RecipeRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_LINT")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MealPlanDisplayViewModel(recipeRepository) as T
    }


}