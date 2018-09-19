package com.software.jgodort.marvelheroes

import android.app.Activity
import android.app.Application
import com.software.jgodort.marvelheroes.dependencyInjection.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Application class that allows us to configure libraries.
 */

class MarvelSampleApp : Application(), HasActivityInjector {

  @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

  override fun onCreate() {
    super.onCreate()


    configureDaggerComponent()
  }

  /**
   * Method that initialize the DaggerComponent with the required modules.
   */
  private fun configureDaggerComponent() {
    DaggerApplicationComponent
        .builder()
        .application(this)
        .build()
        .inject(this)
  }

  override fun activityInjector(): AndroidInjector<Activity> {
    return activityDispatchingAndroidInjector
  }
}
