package com.software.jgodort.marvelheroes.dependencyInjection.module

import android.app.Application
import android.content.Context
import com.software.jgodort.marvelheroes.BuildConfig
import com.software.jgodort.marvelheroes.dependencyInjection.scopes.PerApplication
import com.software.jgodort.marvelheroes.domain.MarvelRepository
import com.software.jgodort.marvelheroes.domain.repository.MarvelSampleRepository
import com.software.jgodort.marvelheroes.network.MarvelServiceFactory
import com.software.jgodort.marvelheroes.network.mapper.SuperheroRemoteMapper
import com.software.jgodort.marvelheroes.threading.PostExecutionThread
import com.software.jgodort.marvelheroes.threading.ThreadExecutor
import com.software.jgodort.marvelheroes.threading.impl.JobExecutor
import com.software.jgodort.marvelheroes.threading.impl.UIThread
import dagger.Module
import dagger.Provides

/**
 * Dagger Module to provides all related with android framework.
 */

@Module
open class ApplicationModule() {

  @Provides
  @PerApplication
  fun provideContext(application: Application): Context {
    return application
  }


  @Provides
  @PerApplication
  internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
    return jobExecutor
  }

  @Provides
  @PerApplication
  internal fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
    return uiThread
  }

  @Provides
  @PerApplication
  internal fun provideMarvelRepository(mapper: SuperheroRemoteMapper): MarvelRepository {
    return MarvelSampleRepository(MarvelServiceFactory.makeMarvelAPI(BuildConfig.DEBUG), mapper)
  }

}