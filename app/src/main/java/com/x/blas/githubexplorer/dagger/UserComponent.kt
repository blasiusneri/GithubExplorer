package com.x.blas.githubexplorer.dagger

import com.x.blas.githubexplorer.dagger.scope.UserScope
import dagger.Component

/**
 * Created by blasius.n.puspika on 27/09/20.
 */

@UserScope
@Component(dependencies = [AppComponent::class], modules = [GitHubModule::class])
interface UserComponent {
}