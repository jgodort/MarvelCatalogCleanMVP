package com.software.jgodort.marvelheroes.presentation.presenter.heroes

import com.software.jgodort.marvelheroes.domain.SuperheroDomain
import com.software.jgodort.marvelheroes.domain.interactors.base.SingleUseCase
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject


class HeroesPresenter @Inject constructor(
  val view: HeroesContract.View,
  private val getHeroesUseCase: SingleUseCase<List<SuperheroDomain>, Void>
) : HeroesContract.Presenter {



  override fun retrieveSuperheroes() {
    getHeroesUseCase.execute(SuperheroesSubscriber())
  }

  override fun start() {
    retrieveSuperheroes()
  }

  override fun stop() {
    getHeroesUseCase.dispose()
  }

  private fun handleGetSuperheroesSuccess(superheroes: List<SuperheroDomain>) {
    view.hideErrorState()
    if (superheroes.isNotEmpty()) {
      view.showSuperHeroes(superheroes)

    } else {
      view.hideSuperHeroes()
    }
  }

  inner class SuperheroesSubscriber : DisposableSingleObserver<List<SuperheroDomain>>() {

    override fun onSuccess(result: List<SuperheroDomain>) {
      handleGetSuperheroesSuccess(result)
    }

    override fun onError(e: Throwable) {
      view.hideSuperHeroes()
      view.showErrorState()
    }

  }
}
