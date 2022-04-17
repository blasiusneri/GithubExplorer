package com.x.blas.githubexplorer.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.x.blas.githubexplorer.databinding.ActivityMainBinding
import com.x.blas.githubexplorer.feature.search.view.SearchUserActivity
import com.x.blas.githubexplorer.utils.setSafeOnClickListener

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bSearch.setSafeOnClickListener {
            startActivity(Intent(this@MainActivity, SearchUserActivity::class.java))
        }
    }
}