package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ui.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun mainActivityInjector() : MainActivity

}