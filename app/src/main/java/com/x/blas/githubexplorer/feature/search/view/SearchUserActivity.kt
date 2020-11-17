package com.x.blas.githubexplorer.feature.search.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.x.blas.githubexplorer.AppViewModelFactory
import com.x.blas.githubexplorer.databinding.ActivitySearchBinding
import com.x.blas.githubexplorer.feature.search.adapter.SearchUserAdapter
import com.x.blas.githubexplorer.feature.search.viewmodel.SearchViewModel
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

        binding.svKeyword.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(keyword: String?): Boolean {
                Toast.makeText(this@SearchUserActivity, "data fetched", Toast.LENGTH_SHORT).show()
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
}