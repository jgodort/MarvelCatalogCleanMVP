package com.software.jgodort.marvelheroes.dependencyInjection.component

import android.app.Application
import com.software.jgodort.marvelheroes.MarvelSampleApp
import com.software.jgodort.marvelheroes.dependencyInjection.module.ActivityBindingModule
import com.software.jgodort.marvelheroes.dependencyInjection.module.ApplicationModule
import com.software.jgodort.marvelheroes.dependencyInjection.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = [ActivityBindingModule::class,
      ApplicationModule::class,
      AndroidSupportInjectionModule::class]
)
interface ApplicationComponent {

  @Component.Builder
  interface Builder {
    @BindsInstance fun application(application: Application): Builder
    fun build(): ApplicationComponent
  }

  fun inject(app: MarvelSampleApp)
}