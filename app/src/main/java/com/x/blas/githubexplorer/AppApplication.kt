package com.x.blas.githubexplorer

import androidx.multidex.MultiDexApplication
import com.x.blas.githubexplorer.dagger.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by blasius.n.puspika on 26/09/20.
 */
class AppApplication : MultiDexApplication(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        val appApplication = DaggerAppComponent.builder().applicationContext(this).build()
        appApplication.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

}