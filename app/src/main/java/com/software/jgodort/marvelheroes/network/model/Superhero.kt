package com.software.jgodort.marvelheroes.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Superhero(

  @SerializedName("name")
  @Expose
  var name: String? = null,
  @SerializedName("photo")
  @Expose
  var photo: String? = null,
  @SerializedName("realName")
  @Expose
  var realName: String? = null,
  @SerializedName("height")
  @Expose
  var height: String? = null,
  @SerializedName("power")
  @Expose
  var power: String? = null,
  @SerializedName("abilities")
  @Expose
  var abilities: String? = null,
  @SerializedName("groups")
  @Expose
  var groups: String? = null
)
