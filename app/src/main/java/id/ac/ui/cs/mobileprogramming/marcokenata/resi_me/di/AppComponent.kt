package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.ResiMeApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ActivityModule::class, FragmentModule::class, NetModule::class, RoomModule::class, ViewModelModule::class, AndroidSupportInjectionModule::class, AppModule::class]
)
interface AppComponent : AndroidInjector<ResiMeApplication> {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: Application): Builder


        fun build(): AppComponent
    }
}