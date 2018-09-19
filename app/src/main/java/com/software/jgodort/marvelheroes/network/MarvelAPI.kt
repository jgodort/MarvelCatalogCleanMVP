package com.software.jgodort.marvelheroes.network

import com.software.jgodort.marvelheroes.network.model.SuperHeroes
import io.reactivex.Single
import retrofit2.http.GET

interface MarvelAPI {

  /**
   * Get a list of <>[com.software.jgodort.marvelheroes.network.model.Superhero]> from the rest service.
   *
   * @return a list of superheroes.
   */
  @GET("v2/5ba2c67c2f000077008d2e67")
  fun marvelSuperHeroes(): Single<SuperHeroes>
}
