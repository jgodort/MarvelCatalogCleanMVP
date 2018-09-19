package com.software.jgodort.marvelheroes.presentation.ui.adapters

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.software.jgodort.marvelheroes.R
import com.software.jgodort.marvelheroes.domain.SuperheroDomain
import javax.inject.Inject

/**
 * Adapter to display the list of heroes retrieved  by the API.
 */

class HeroesAdapter @Inject constructor(
  private val activity: Activity,
  val clickListener: (Pair<SuperheroDomain, Bundle?>) -> Unit
) :
    RecyclerView.Adapter<HeroesAdapter.ViewHolder>() {

  /**
   * List of heroes.
   */
  var heroes: List<SuperheroDomain> = arrayListOf()

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): ViewHolder {
    val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_layout_hero, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(
    holder: ViewHolder,
    position: Int
  ) {

    val hero = heroes[position]


    //Load round image using Glide.
    Glide.with(holder.itemView.context)
        .load(hero.photo)
        .apply(RequestOptions.circleCropTransform())
        .into(holder.heroProfileImage)

    holder.superHeroName.text = hero.name
    holder.realName.text = hero.realName
    holder.heroGroups.text = hero.groups

    holder.itemView?.setOnClickListener {
      clickListener(
          Pair(hero, generateAnimationBundle(holder))
      )
    }

  }

  private fun generateAnimationBundle(viewHolder: ViewHolder): Bundle? {
    viewHolder.itemView.context

    val p1 = android.support.v4.util.Pair.create(
        viewHolder.heroProfileImage as View,
        activity.getString(R.string.image_animation_name)
    )
    val p2 = android.support.v4.util.Pair.create(
        viewHolder.superHeroName as View, activity.getString(R.string.superhero_animation_name)
    )
    val p3 = android.support.v4.util.Pair.create(
        viewHolder.superHeroName as View, activity.getString(R.string.realname_animation_name)
    )

    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, p1, p2, p3)

    return options.toBundle()
  }

  override fun getItemCount(): Int {
    return heroes.size
  }

  /**
   * View holder to represent one item on the list.
   */
  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    //var cardViewHero: CardView = itemView.findViewById(R.id.card_item)

    var heroProfileImage: ImageView = itemView.findViewById(R.id.hero_image)

    var superHeroName: TextView = itemView.findViewById(R.id.superhero_name)

    var realName: TextView = itemView.findViewById(R.id.real_name)

    var heroGroups: TextView = itemView.findViewById(R.id.hero_groups)

  }
}
