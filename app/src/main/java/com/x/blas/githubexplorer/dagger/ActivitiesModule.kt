package com.x.blas.githubexplorer.dagger

import com.x.blas.githubexplorer.feature.search.view.SearchUserActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by blasius.n.puspika on 04/10/20.
 */

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = [(AppModule::class)])
    abstract fun contributeActivityAndroidInjector(): SearchUserActivity
}