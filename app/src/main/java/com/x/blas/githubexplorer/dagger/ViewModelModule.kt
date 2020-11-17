package com.x.blas.githubexplorer.dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.x.blas.githubexplorer.AppViewModelFactory
import com.x.blas.githubexplorer.ViewModelKey
import com.x.blas.githubexplorer.feature.search.viewmodel.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by blasius.n.puspika on 09/11/20.
 */

@Module abstract class ViewModelModule {

    @Binds abstract fun bindViewModelFactory(factoryApp: AppViewModelFactory): ViewModelProvider.Factory

    @Binds @IntoMap @ViewModelKey(SearchViewModel::class) abstract fun bindMainViewModel(
        mainViewModel: SearchViewModel): ViewModel
}