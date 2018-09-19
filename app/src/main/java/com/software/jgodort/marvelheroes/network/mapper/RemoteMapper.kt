package com.software.jgodort.marvelheroes.network.mapper

interface RemoteMapper<in M, out E> {

  fun mapFromRemote(type:M):E
}