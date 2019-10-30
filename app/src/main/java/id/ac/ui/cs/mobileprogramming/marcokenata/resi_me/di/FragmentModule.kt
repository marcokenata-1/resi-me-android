package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.homeview.Home
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.mealplans.MealPlan
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.savedrecipes.SavedMenu

@Module
abstract class FragmentModule() {

    @ContributesAndroidInjector
    internal abstract fun Home() : Home

    @ContributesAndroidInjector
    internal abstract fun MealPlan() : MealPlan

    @ContributesAndroidInjector
    internal abstract fun SavedMenu() : SavedMenu
}