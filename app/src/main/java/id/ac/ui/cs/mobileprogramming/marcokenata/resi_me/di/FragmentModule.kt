package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.addmealplan.MealPlanAdder
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.categoryhandler.CategoryHandler
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.congratulations.Congratulations
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.cookingsteps.CookingStep
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.homeview.Home
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.ingredient.Ingredient
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.mealplandisplay.MealPlanDisplay
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

    @ContributesAndroidInjector
    internal abstract fun Ingredient() : Ingredient

    @ContributesAndroidInjector
    internal abstract fun CookingStep() : CookingStep

    @ContributesAndroidInjector
    internal abstract fun Congratulations() : Congratulations

    @ContributesAndroidInjector
    internal abstract fun CategoryHandler() : CategoryHandler

    @ContributesAndroidInjector
    internal abstract fun MealPlanAdder() : MealPlanAdder

    @ContributesAndroidInjector
    internal abstract fun MealPlanDisplay() : MealPlanDisplay
}