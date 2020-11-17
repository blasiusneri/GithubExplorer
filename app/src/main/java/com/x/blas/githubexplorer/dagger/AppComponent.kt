package com.x.blas.githubexplorer.dagger

import android.app.Application
import com.x.blas.githubexplorer.AppApplication
import com.x.blas.githubexplorer.dagger.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


/**
 * Created by blasius.n.puspika on 26/09/20.
 */
@ApplicationScope
@Component(modules = [AndroidInjectionModule::class, AppModule::class, NetworkModule::class, ActivityBuilder::class, ViewModelModule::class])
interface AppComponent: AndroidInjector<AppApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(application: Application): Builder
        fun build(): AppComponent
    }
}