package com.x.blas.githubexplorer.dagger

import com.x.blas.githubexplorer.dagger.binder.ApplicationBinder
import dagger.Component
import javax.inject.Provider
import javax.inject.Singleton


/**
 * Created by blasius.n.puspika on 26/09/20.
 */
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, ApplicationBinder::class])
interface AppComponent {

    /*fun activitySubcomponent(activityModule: ActivityModule): ActivitySubComponent*/
    fun subcomponentBuilders(): MutableMap<Class<*>?, Provider<SubcomponentBuilder<*>>>
}