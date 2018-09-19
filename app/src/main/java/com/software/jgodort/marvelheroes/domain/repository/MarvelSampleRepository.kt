package com.software.jgodort.marvelheroes.domain.repository

import com.software.jgodort.marvelheroes.domain.MarvelRepository
import com.software.jgodort.marvelheroes.domain.SuperheroDomain
import com.software.jgodort.marvelheroes.network.MarvelAPI
import com.software.jgodort.marvelheroes.network.mapper.SuperheroRemoteMapper
import io.reactivex.Single
import javax.inject.Inject

class MarvelSampleRepository @Inject constructor(
  private val api: MarvelAPI,
  private val mapper: SuperheroRemoteMapper
) : MarvelRepository {

  override fun getSuperheroes(): Single<List<SuperheroDomain>> {

    return api.marvelSuperHeroes()
        .map { it.superheroes.map { mapper.mapFromRemote(it) } }
  }
}