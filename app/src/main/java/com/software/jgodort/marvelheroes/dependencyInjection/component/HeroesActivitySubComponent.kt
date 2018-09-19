package com.software.jgodort.marvelheroes.dependencyInjection.component

import com.software.jgodort.marvelheroes.presentation.ui.HeroesActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface HeroesActivitySubComponent : AndroidInjector<HeroesActivity> {
  @Subcomponent.Builder
  abstract class Builder : AndroidInjector.Builder<HeroesActivity>()

}