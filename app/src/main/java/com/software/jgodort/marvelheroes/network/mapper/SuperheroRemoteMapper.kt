package com.software.jgodort.marvelheroes.network.mapper

import com.software.jgodort.marvelheroes.domain.SuperheroDomain
import com.software.jgodort.marvelheroes.network.model.Superhero
import javax.inject.Inject

class SuperheroRemoteMapper @Inject constructor() : RemoteMapper<Superhero, SuperheroDomain> {

  override fun mapFromRemote(type: Superhero): SuperheroDomain {
    return SuperheroDomain(
        type.name, type.photo,
        type.realName, type.height,
        type.power, type.abilities,
        type.groups
    )
  }
}