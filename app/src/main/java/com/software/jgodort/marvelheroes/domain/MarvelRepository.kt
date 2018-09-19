package com.software.jgodort.marvelheroes.domain

import io.reactivex.Single

interface MarvelRepository {
  fun getSuperheroes(): Single<List<SuperheroDomain>>
}