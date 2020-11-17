package com.x.blas.githubexplorer.feature.search.repository.contract

import com.x.blas.githubexplorer.feature.search.model.SearchList
import io.reactivex.Observable

/**
 * Created by blasius.n.puspika on 08/11/20.
 */

interface GithubRepository {

    fun getSearchList(keyword: String): Observable<SearchList>
}