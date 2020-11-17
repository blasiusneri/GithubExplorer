package com.x.blas.githubexplorer.service

import com.x.blas.githubexplorer.feature.search.model.SearchList
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by blasius.n.puspika on 08/11/20.
 */

interface GithubService {

    @GET("https://api.github.com/search/users")
    fun getUserList(@Query("q") keyword: String): Observable<SearchList>
}