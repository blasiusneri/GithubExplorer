package com.x.blas.githubexplorer.dagger

import android.widget.ArrayAdapter
import com.x.blas.githubexplorer.MainActivity
import com.x.blas.githubexplorer.dagger.scope.ActivityScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by blasius.n.puspika on 27/09/20.
 */

@Module
class ActivityModule(var mainActivity: MainActivity) {

    @Provides
    @ActivityScope
    @Named("activityList")
    fun provideActivityListAdapter(): ArrayAdapter<String> {
        return ArrayAdapter<String>(mainActivity, android.R.layout.activity_list_item)
    }
}