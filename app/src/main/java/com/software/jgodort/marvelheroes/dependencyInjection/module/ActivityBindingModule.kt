package com.software.jgodort.marvelheroes.dependencyInjection.module

import com.software.jgodort.marvelheroes.dependencyInjection.scopes.PerActivity
import com.software.jgodort.marvelheroes.presentation.ui.HeroesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

  @PerActivity
  @ContributesAndroidInjector(modules = [(HeroesActivityModule::class)])
  abstract fun bindHeroesActivity(): HeroesActivity

}