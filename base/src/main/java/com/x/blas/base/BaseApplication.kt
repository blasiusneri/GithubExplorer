package com.x.blas.base

import androidx.multidex.MultiDexApplication
import com.x.blas.base.component.BaseComponent
import com.x.blas.base.component.DaggerBaseComponent

/**
 * Created by blasius.n.puspika on 17/11/20.
 */

//MODULARIZED - 2.01.1 create base application and extend this to AppComponent
open class BaseApplication : MultiDexApplication() {

    companion object {
        //MODULARIZED - 2.09 create base component attribute so child class (AppApplication.kt) can get the it
        lateinit var baseComponent: BaseComponent
    }

    override fun onCreate() {
        super.onCreate()
        //MODULARIZED - 2.10 Declare baseComponent and inject it
        baseComponent = DaggerBaseComponent.builder().applicationContext(this).build()
        baseComponent.inject(this)
    }
}