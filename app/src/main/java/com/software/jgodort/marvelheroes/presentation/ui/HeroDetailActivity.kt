package com.software.jgodort.marvelheroes.presentation.ui

import android.os.Bundle
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.software.jgodort.marvelheroes.R
import com.software.jgodort.marvelheroes.domain.SuperheroDomain
import kotlinx.android.synthetic.main.hero_details.hero_abilitites
import kotlinx.android.synthetic.main.hero_details.hero_groups
import kotlinx.android.synthetic.main.hero_details.hero_image_profile
import kotlinx.android.synthetic.main.hero_details.hero_info
import kotlinx.android.synthetic.main.hero_details.hero_powers
import kotlinx.android.synthetic.main.hero_details.real_name
import kotlinx.android.synthetic.main.hero_details.superhero_name

/**
 * Activity to display the details of the selected hero.
 * At is does not have business interaction or any specific logic, we don´t implement a Presenter.
 *
 *
 */
class HeroDetailActivity : AppCompatActivity() {

  public override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.hero_details)

    val bundle = intent.extras
    if (bundle != null) {
      initializeView(
          bundle.getParcelable<Parcelable>(HeroesActivity.HERO_BUNDLE) as SuperheroDomain
      )
    }
  }

  /**
   * Method to initialize variables in the view.
   *
   * @param hero selected hero.
   */
  private fun initializeView(hero: SuperheroDomain) {

    hero_powers.text = hero.power
    hero_abilitites.text = hero.abilities
    hero_groups.text = hero.groups
    hero_info.text = hero.height
    superhero_name.text = hero.name
    real_name.text = hero.realName

    //Load round image using Glide.
    Glide.with(this)
        .load(hero.photo)
        .apply(RequestOptions.circleCropTransform())
        .into(hero_image_profile)
  }
}
