package com.x.blas.githubexplorer.feature.search.repository.impl

import com.x.blas.githubexplorer.feature.search.model.SearchList
import com.x.blas.githubexplorer.feature.search.repository.contract.GithubRepository
import com.x.blas.githubexplorer.service.GithubService
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by blasius.n.puspika on 08/11/20.
 */
class GithubRepositoryImpl @Inject constructor(private val githubService: GithubService) : GithubRepository {

    override fun getSearchList(keyword: String): Observable<SearchList> {
        return githubService.getUserList(keyword)
    }
}