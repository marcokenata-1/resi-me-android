package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.Home.HomeViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MealPlan.MealPlanViewModel
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.SavedMenu.SavedMenuViewModel

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

}