package com.x.blas.githubexplorer

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.x.blas.githubexplorer.dagger.ActivityModule
import com.x.blas.githubexplorer.dagger.ActivitySubComponent
import com.x.blas.githubexplorer.sharedpreference.UserSharedPreference
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
  @Inject
  lateinit var userSharedPreference: UserSharedPreference

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    /*(application as AppController).getAppComponent()
      .activitySubcomponent(ActivityModule(this)).inject(this)*/
    val builder = (application as AppController).getAppComponent().subcomponentBuilders()[ActivitySubComponent.Builder::class.java]
      ?.get() as ActivitySubComponent.Builder
    builder.activityModule(ActivityModule(this)).build().inject(this)

    userSharedPreference.setUsername(this, "Hello")
    findViewById<TextView>(R.id.tv_main).text = userSharedPreference.getUsername(this)
  }
}