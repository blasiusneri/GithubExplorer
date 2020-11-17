package com.x.blas.githubexplorer.dagger

import com.x.blas.githubexplorer.dagger.module.AppModule
import com.x.blas.githubexplorer.feature.search.view.SearchUserActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by blasius.n.puspika on 28/09/20.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [AppModule::class])
    abstract fun bindMainActivity(): SearchUserActivity
}