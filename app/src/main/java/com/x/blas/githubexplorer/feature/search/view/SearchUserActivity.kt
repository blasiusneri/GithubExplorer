package com.x.blas.githubexplorer.feature.search.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.x.blas.githubexplorer.databinding.ActivitySearchBinding
import com.x.blas.githubexplorer.feature.search.adapter.SearchUserAdapter
import com.x.blas.githubexplorer.feature.search.viewmodel.SearchViewModel
import com.x.blas.githubexplorer.utils.AppViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class SearchUserActivity : AppCompatActivity() {

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    private lateinit var binding: ActivitySearchBinding

    private val viewModel by viewModels<SearchViewModel> { appViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.svKeyword.setOnClickListener {
            binding.svKeyword.isIconified = false
        }

        viewModel.showLoading.observe(this, Observer { values ->
            if (values == true) {
                binding.pbSearchUser.visibility = View.VISIBLE
                binding.rvUserList.visibility = View.GONE
            } else {
                binding.pbSearchUser.visibility = View.GONE
                binding.rvUserList.visibility = View.VISIBLE
            }
        })

        binding.svKeyword.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(keyword: String?): Boolean {
                hideSoftKeyboard(binding.svKeyword)
                viewModel.fetchSearchList(keyword.orEmpty())
                viewModel.searchList.observe(this@SearchUserActivity, Observer { value ->
                    val adapter = SearchUserAdapter(value)
                    binding.rvUserList.adapter = adapter
                    val layoutManager = LinearLayoutManager(this@SearchUserActivity)
                    binding.rvUserList.layoutManager = layoutManager
                })
                return true
            }

            override fun onQueryTextChange(keyword: String?): Boolean = false
        })
    }

    fun hideSoftKeyboard(view: View) {
        val imm: InputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}