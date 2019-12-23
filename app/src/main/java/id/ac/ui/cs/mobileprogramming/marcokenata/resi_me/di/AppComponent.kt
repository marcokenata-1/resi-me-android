package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ResiMeApplication
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ActivityModule::class,FragmentModule::class,NetModule::class,RoomModule::class,ViewModelModule::class,AndroidSupportInjectionModule::class))
interface AppComponent : AndroidInjector<ResiMeApplication>{



    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder
        fun netModuleImplementation(netModule: NetModule)
        fun build(): AppComponent
    }
}