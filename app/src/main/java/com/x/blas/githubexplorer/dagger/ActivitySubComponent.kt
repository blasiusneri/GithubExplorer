package com.x.blas.githubexplorer.dagger

import com.x.blas.githubexplorer.MainActivity
import com.x.blas.githubexplorer.dagger.scope.ActivityScope
import dagger.Subcomponent

/**
 * Created by blasius.n.puspika on 27/09/20.
 */

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivitySubComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder : SubcomponentBuilder<ActivitySubComponent> {
        fun activityModule(module: ActivityModule): Builder
    }
}

interface SubcomponentBuilder<V> {
    fun build(): V
}