package com.software.jgodort.marvelheroes.presentation.presenter.heroes

import com.software.jgodort.marvelheroes.domain.SuperheroDomain
import com.software.jgodort.marvelheroes.network.model.Superhero
import com.software.jgodort.marvelheroes.presentation.presenter.base.BasePresenter
import com.software.jgodort.marvelheroes.presentation.ui.base.BaseView

interface HeroesContract {

  interface View : BaseView<Presenter> {

    fun showProgress()

    fun hideProgress()

    fun showSuperHeroes(superheroes: List<SuperheroDomain>)

    fun hideSuperHeroes()

    fun showErrorState()

    fun hideErrorState()
  }

  interface Presenter:BasePresenter{
    fun retrieveSuperheroes()
  }
}