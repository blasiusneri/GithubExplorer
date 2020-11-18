package com.x.blas.githubexplorer.dagger.module

import com.x.blas.githubexplorer.service.GithubService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by blasius.n.puspika on 26/09/20.
 */

//MODULARIZED - 2.03 Create new module for provide Service
@Module
class NetworkServiceModule {

    @Provides
    fun provideGithubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }
}