package com.x.blas.githubexplorer.dagger.module

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.x.blas.base.scope.BaseScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by blasius.n.puspika on 26/09/20.
 */
@Module
//MODULARIZED - 2.03 Move NetworkModule to base but keep the GithubService Provider in app module, so create new GithubServiceModule.kt for GithubService Provider
class NetworkModule {

    private companion object {
        const val GITHUB_URL = "https://api.github.com/"

        //set github access token here
        const val ACCESS_TOKEN = "d9b655ef677bffc1784f1ed132e28f036e67f2b8"
    }

    //MODULARIZED - 2.02.3 change ApplicationScope to BaseScope in NetworkModule in all places
    @Provides
    @BaseScope
    fun providesSharedPreferences(application: Application): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @BaseScope
    fun provideOkHttpCache(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @BaseScope
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @BaseScope
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder().addInterceptor(Interceptor {
            val request = it.request().newBuilder()
                .addHeader("Authorization", "token $ACCESS_TOKEN")
                .build()
            return@Interceptor it.proceed(request)
        }).cache(cache)
        return client.build()
    }

    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(GITHUB_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}