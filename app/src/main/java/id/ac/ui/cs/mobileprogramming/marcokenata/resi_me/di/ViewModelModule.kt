package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.addmealplan.MealPlanAdder
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.addmealplan.MealPlanAdderViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.categoryhandler.CategoryHandlerViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.congratulations.Congratulations
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.congratulations.CongratulationsViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.cookingsteps.CookingStepViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.homeview.HomeViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.ingredient.IngredientViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.mealplandisplay.MealPlanDisplayViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.mealplans.MealPlanViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.savedrecipes.SavedMenuViewModel

@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MealPlanViewModel::class)
    abstract fun bindMealPlanViewModel(viewModel: MealPlanViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SavedMenuViewModel::class)
    abstract fun bindSavedMenuViewModel(viewModel: SavedMenuViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(IngredientViewModel::class)
    abstract fun bindIngredientViewModel(viewModel: IngredientViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CookingStepViewModel::class)
    abstract fun bindCookingStepViewModel(viewModel: CookingStepViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CongratulationsViewModel::class)
    abstract fun bindCongratulationsViewModel(viewModel: CongratulationsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CategoryHandlerViewModel::class)
    abstract fun bindCategoryHandlerViewModel(viewModel: CategoryHandlerViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MealPlanAdderViewModel::class)
    abstract fun bindMealPlanAdderViewModel(viewModel: MealPlanAdderViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MealPlanDisplayViewModel::class)
    abstract fun bindMealPlanDisplayViewModel(viewModel: MealPlanDisplayViewModel) : ViewModel
}