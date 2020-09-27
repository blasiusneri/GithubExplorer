package com.x.blas.githubexplorer.dagger

import com.x.blas.githubexplorer.dagger.scope.UserScope
import dagger.Module
import dagger.Provides
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by blasius.n.puspika on 27/09/20.
 */

@Module
class GitHubModule {

    interface GitHubInterface {
        @GET("/org/{orgName}/repos")
        fun getRepository(@Path("orgName") orgName: String): Call<List<String>>
    }

    @Provides
    @UserScope
    fun provideGitHubApiInterface(retrofit: Retrofit): GitHubInterface {
        return retrofit.create(GitHubInterface::class.java)
    }
}