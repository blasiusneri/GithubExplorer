package com.x.blas.githubexplorer.dagger.component

import android.app.Application
import com.x.blas.base.component.BaseComponent
import com.x.blas.githubexplorer.AppApplication
import com.x.blas.githubexplorer.dagger.ActivityBuilder
import com.x.blas.githubexplorer.dagger.module.AppModule
import com.x.blas.githubexplorer.dagger.module.NetworkServiceModule
import com.x.blas.githubexplorer.dagger.module.ViewModelModule
import com.x.blas.githubexplorer.dagger.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


/**
 * Created by blasius.n.puspika on 26/09/20.
 */
@ApplicationScope
@Component(
    modules = [AndroidInjectionModule::class, ActivityBuilder::class, ViewModelModule::class, AppModule::class, NetworkServiceModule::class],
    dependencies = [BaseComponent::class]
)
interface AppComponent : AndroidInjector<AppApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(application: Application): Builder
        fun baseComponent(baseComponent: BaseComponent): Builder
        fun build(): AppComponent
    }
}