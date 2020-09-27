package com.x.blas.githubexplorer.dagger.binder

import com.x.blas.githubexplorer.dagger.ActivitySubComponent
import com.x.blas.githubexplorer.dagger.SubcomponentBuilder
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Created by blasius.n.puspika on 27/09/20.
 */

@Module(subcomponents = [ActivitySubComponent::class])
abstract class ApplicationBinder {

    @Binds
    @IntoMap
    @SubcomponentKey(ActivitySubComponent.Builder::class)
    abstract fun myActivity(impl: ActivitySubComponent.Builder?): SubcomponentBuilder<*>?
}