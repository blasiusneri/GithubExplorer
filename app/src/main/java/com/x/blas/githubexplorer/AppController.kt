package com.x.blas.githubexplorer

import android.app.Application
import com.x.blas.githubexplorer.dagger.*

/**
 * Created by blasius.n.puspika on 26/09/20.
 */
class AppController : Application() {

    private lateinit var appComponent: AppComponent
    private lateinit var userComponent: UserComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .networkModule(NetworkModule("https://api.github.com"))
            .build()

        userComponent =DaggerUserComponent.builder()
            .appComponent(appComponent)
            .gitHubModule(GitHubModule())
            .build()
    }

    fun getAppComponent(): AppComponent = appComponent

    fun getUserComponent(): UserComponent = userComponent

}