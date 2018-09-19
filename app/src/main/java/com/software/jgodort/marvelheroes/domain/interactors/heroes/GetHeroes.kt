package com.software.jgodort.marvelheroes.domain.interactors.heroes

import com.software.jgodort.marvelheroes.domain.MarvelRepository
import com.software.jgodort.marvelheroes.domain.SuperheroDomain
import com.software.jgodort.marvelheroes.domain.interactors.base.SingleUseCase
import com.software.jgodort.marvelheroes.network.model.Superhero
import com.software.jgodort.marvelheroes.threading.PostExecutionThread
import com.software.jgodort.marvelheroes.threading.ThreadExecutor
import io.reactivex.Single
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Superhero] instances from the [MarvelSampleRepository]
 */
open class GetHeroes @Inject constructor(
  private val repository: MarvelRepository,
  threadExecutor: ThreadExecutor,
  postExecutionThread: PostExecutionThread
) : SingleUseCase<List<SuperheroDomain>, Void?>(threadExecutor, postExecutionThread) {

  override fun buildUseCaseObservable(params: Void?): Single<List<SuperheroDomain>> {
    return repository.getSuperheroes()
  }

}