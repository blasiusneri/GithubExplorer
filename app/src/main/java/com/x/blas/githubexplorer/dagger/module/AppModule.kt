package com.x.blas.githubexplorer.dagger.module

import com.x.blas.githubexplorer.feature.search.repository.contract.GithubRepository
import com.x.blas.githubexplorer.feature.search.repository.impl.GithubRepositoryImpl
import dagger.Binds
import dagger.Module

/**
 * Created by blasius.n.puspika on 26/09/20.
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun provideGithubRepository(githubRepository: GithubRepositoryImpl): GithubRepository
}