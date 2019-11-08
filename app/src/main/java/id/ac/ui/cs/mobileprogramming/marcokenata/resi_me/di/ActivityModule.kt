package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.*

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivityInjector() : MainActivity

    @ContributesAndroidInjector
    internal abstract fun recipeActivityInjector() : RecipeActivity

    @ContributesAndroidInjector
    internal abstract fun categoryActivityInjector() : CategoryActivity

    @ContributesAndroidInjector
    internal abstract fun adderActivityInjector() : AdderActivity

    @ContributesAndroidInjector
    internal abstract fun mealPlanActivityInjector() : MealPlanActivity
}