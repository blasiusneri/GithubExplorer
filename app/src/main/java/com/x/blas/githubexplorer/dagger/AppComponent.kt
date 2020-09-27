package com.x.blas.githubexplorer.dagger

import android.content.SharedPreferences
import dagger.Component
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * Created by blasius.n.puspika on 26/09/20.
 */
@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun retrofit(): Retrofit
    fun okHttpClient(): OkHttpClient
    fun sharedPreferences(): SharedPreferences
}