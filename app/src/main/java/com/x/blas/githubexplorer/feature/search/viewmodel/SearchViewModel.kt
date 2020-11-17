package com.x.blas.githubexplorer.feature.search.viewmodel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.x.blas.githubexplorer.feature.search.model.SearchList
import com.x.blas.githubexplorer.feature.search.repository.contract.GithubRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by blasius.n.puspika on 08/11/20.
 */
class SearchViewModel @Inject constructor(private val githubRepository: GithubRepository) :
    ViewModel() {

    val showLoading: LiveData<Boolean>
        get() = _showLoading

    private var _showLoading = MutableLiveData<Boolean>().apply { value = false }

    val searchList: LiveData<SearchList>
        get() = _searchList

    private var _searchList = MutableLiveData<SearchList>()

    @SuppressLint("CheckResult")
    fun fetchSearchList(keyword: String) {
        _showLoading.value = true
        githubRepository.getSearchList(keyword).subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread()
        ).subscribe({
            _showLoading.value = false
            _searchList.value = it
        },{
            _showLoading.value = false
            Log.e("ERROR fetchSearchList", it.message)
        })
    }
}