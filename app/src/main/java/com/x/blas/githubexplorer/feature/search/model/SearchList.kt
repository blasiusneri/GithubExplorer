package com.x.blas.githubexplorer.feature.search.model

data class SearchList(
    val incomplete_results: Boolean,
    val items: List<Item>? = null,
    val total_count: Int
)