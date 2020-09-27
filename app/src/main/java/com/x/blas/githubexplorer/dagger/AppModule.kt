package com.x.blas.githubexplorer.dagger

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by blasius.n.puspika on 26/09/20.
 */
@Module
class AppModule constructor(var application: Application){

    @Provides
    @Singleton
    fun providesApplication(): Application {
        return application
    }
}