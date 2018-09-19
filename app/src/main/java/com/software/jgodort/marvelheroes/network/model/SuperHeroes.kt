package com.software.jgodort.marvelheroes.network.model

import com.google.gson.annotations.SerializedName

class SuperHeroes {

  @SerializedName("superheroes")
  var superheroes: List<Superhero> = emptyList()

}
