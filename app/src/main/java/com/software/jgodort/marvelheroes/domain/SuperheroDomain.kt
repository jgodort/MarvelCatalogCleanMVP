package com.software.jgodort.marvelheroes.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SuperheroDomain(
  var name: String? = null,
  var photo: String? = null,
  var realName: String? = null,
  var height: String? = null,
  var power: String? = null,
  var abilities: String? = null,
  var groups: String? = null
) : Parcelable