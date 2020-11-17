package com.x.blas.githubexplorer.network

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by blasius.n.puspika on 08/11/20.
 */

class GithubExplorerInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(request)

    }
}