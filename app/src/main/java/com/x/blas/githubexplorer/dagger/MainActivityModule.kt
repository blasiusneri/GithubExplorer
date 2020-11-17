package com.x.blas.githubexplorer.dagger

import com.x.blas.githubexplorer.feature.search.view.SearchUserActivity
import com.x.blas.githubexplorer.dagger.scope.MainScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by blasius.n.puspika on 28/09/20.
 */

@Module
abstract class MainActivityModule {

    @MainScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivityInjector(): SearchUserActivity
}