package com.software.jgodort.marvelheroes.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.software.jgodort.marvelheroes.R
import com.software.jgodort.marvelheroes.domain.SuperheroDomain
import com.software.jgodort.marvelheroes.presentation.presenter.heroes.HeroesContract
import com.software.jgodort.marvelheroes.presentation.ui.adapters.HeroesAdapter
import com.software.jgodort.marvelheroes.presentation.ui.extension.gone
import com.software.jgodort.marvelheroes.presentation.ui.extension.visible
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_heroes.errorView
import kotlinx.android.synthetic.main.activity_heroes.loadingAnimation
import kotlinx.android.synthetic.main.activity_heroes.loadingView
import kotlinx.android.synthetic.main.activity_heroes.recyclerSuperHeroes
import kotlinx.android.synthetic.main.activity_heroes.swipe_refresh_layout
import kotlinx.android.synthetic.main.activity_heroes.toolbar
import javax.inject.Inject

class HeroesActivity :
    AppCompatActivity(),
    HeroesContract.View {

  @Inject lateinit var heroesPresenter: HeroesContract.Presenter
  var heroesAdapter: HeroesAdapter? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_heroes)
    AndroidInjection.inject(this)
    toolbar.title = getString(R.string.toolbarTitle)
    configureRecycler()
  }

  private fun configureRecycler() {
    //Configure RecyclerView
    recyclerSuperHeroes.layoutManager =
        LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    //Configure Adapter
    heroesAdapter =
        HeroesAdapter(this) { hero: kotlin.Pair<SuperheroDomain, Bundle?> ->
          onHeroSelected(
              hero.first, hero.second
          )
        }
    recyclerSuperHeroes.adapter = heroesAdapter

    //Configure swipe refres layout.
    swipe_refresh_layout.setOnRefreshListener { heroesPresenter.retrieveSuperheroes() }

  }

  override fun onStart() {
    super.onStart()
    heroesPresenter.start()
  }

  private fun onHeroSelected(
    hero: SuperheroDomain,
    animationBundle: Bundle?
  ) {

    val intent = Intent(this, HeroDetailActivity::class.java)
    val extras = Bundle()
    extras.putParcelable(HERO_BUNDLE, hero)
    intent.putExtras(extras)
    startActivity(intent, animationBundle)
  }

  override fun showProgress() {
    errorView.gone()
    recyclerSuperHeroes.gone()
    loadingView.visible()
    loadingAnimation.playAnimation()
  }

  override fun hideProgress() {
    loadingView.gone()
    loadingAnimation.playAnimation()
  }

  override fun showSuperHeroes(superheroes: List<SuperheroDomain>) {
    heroesAdapter?.heroes = superheroes
    heroesAdapter?.notifyDataSetChanged()
    recyclerSuperHeroes.visible()
    swipe_refresh_layout.isRefreshing = false
  }

  override fun hideSuperHeroes() {
    recyclerSuperHeroes.gone()
  }

  override fun showErrorState() {
    swipe_refresh_layout.isRefreshing = false
    errorView.visible()
  }

  override fun hideErrorState() {

    errorView.gone()
  }

  companion object {

    const val HERO_BUNDLE = "HEROBUNDLE_KEY"
  }

}
