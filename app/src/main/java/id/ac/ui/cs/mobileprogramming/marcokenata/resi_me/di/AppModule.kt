package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import dagger.Module
import dagger.Provides
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ResiMeApplication

@Module
class AppModule {

    @Provides
    fun application() : ResiMeApplication{
        return ResiMeApplication()
    }
}