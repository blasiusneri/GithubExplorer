package com.x.blas.base.component

import android.app.Application
import com.x.blas.base.BaseApplication
import com.x.blas.base.scope.BaseScope
import com.x.blas.githubexplorer.dagger.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import retrofit2.Retrofit

/**
 * Created by blasius.n.puspika on 17/11/20.
 */

@BaseScope
@Component(modules = [NetworkModule::class])
interface BaseComponent : AndroidInjector<BaseApplication> {

    //MODULARIZED - 2.04 Create builder for BaseComponent
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(application: Application): Builder
        fun build(): BaseComponent
    }

    //MODULARIZED - 2.05 Exposed Retrofit to be used in service
    fun retrofit(): Retrofit
}