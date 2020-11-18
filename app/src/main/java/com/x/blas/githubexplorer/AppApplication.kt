package com.x.blas.githubexplorer

import com.x.blas.base.BaseApplication
import com.x.blas.githubexplorer.dagger.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Created by blasius.n.puspika on 26/09/20.
 */
class AppApplication : BaseApplication(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        //MODULARIZED - 2.12 add baseComponent and passing baseComponent from parent class
        val appApplication = DaggerAppComponent.builder().applicationContext(this).baseComponent(
            baseComponent
        ).build()
        appApplication.inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

}