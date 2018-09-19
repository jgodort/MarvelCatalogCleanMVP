package com.software.jgodort.marvelheroes.dependencyInjection.module

import com.software.jgodort.marvelheroes.dependencyInjection.scopes.PerActivity
import com.software.jgodort.marvelheroes.domain.interactors.heroes.GetHeroes
import com.software.jgodort.marvelheroes.presentation.presenter.heroes.HeroesContract
import com.software.jgodort.marvelheroes.presentation.presenter.heroes.HeroesPresenter
import com.software.jgodort.marvelheroes.presentation.ui.HeroesActivity
import dagger.Module
import dagger.Provides

@Module
open class HeroesActivityModule {

  @PerActivity
  @Provides
  internal fun providesHeroesView(heroesActivity: HeroesActivity): HeroesContract.View {
    return heroesActivity
  }

  @PerActivity
  @Provides
  internal fun providesHeroesPresenter(
    heroesView: HeroesContract.View,
    getHeroes: GetHeroes
  ): HeroesContract.Presenter {

    return HeroesPresenter(heroesView, getHeroes)
  }

}