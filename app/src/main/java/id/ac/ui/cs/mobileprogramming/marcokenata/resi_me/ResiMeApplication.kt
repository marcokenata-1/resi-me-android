package id.ac.ui.cs.mobileprogramming.marcokenata.resi_me

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di.AppModule
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di.DaggerAppComponent
import id.ac.ui.cs.mobileprogramming.marcokenata.resi_me.di.NetModule
import javax.inject.Inject

class ResiMeApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)

//            .netModuleImplementation(NetModule(context = this.applicationContext))
            .build()
            .inject(this)


    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector
}