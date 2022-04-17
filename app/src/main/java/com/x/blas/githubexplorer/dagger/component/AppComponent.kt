package com.x.blas.githubexplorer.dagger.component

import android.app.Application
import com.x.blas.base.component.BaseComponent
import com.x.blas.githubexplorer.AppApplication
import com.x.blas.githubexplorer.dagger.ActivityBuilder
import com.x.blas.githubexplorer.dagger.module.AppModule
import com.x.blas.githubexplorer.dagger.module.GithubServiceModule
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
    modules = [AndroidInjectionModule::class, ActivityBuilder::class, ViewModelModule::class, AppModule::class, GithubServiceModule::class],
    //MODULARIZED - 2.08 add BaseComponent so retrofit can supplied to AppComponent
    dependencies = [BaseComponent::class]
)
interface AppComponent : AndroidInjector<AppApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(application: Application): Builder
        //MODULARIZED - 2.11 add BaseComponent in AppComponentBuilder
        fun baseComponent(baseComponent: BaseComponent): Builder
        fun build(): AppComponent
    }
}