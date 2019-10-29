package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MealPlan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.data.repository.RecipeRepository
import javax.inject.Inject

@Module
class MealPlanViewModelFactory @Inject constructor(private val recipeRepository: RecipeRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MealPlanViewModel(recipeRepository) as T
    }

}