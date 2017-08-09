package com.software.jgodort.marvelheroes.dependencyInjection;

import com.software.jgodort.marvelheroes.presentation.presenter.HeroesPresenter;
import com.software.jgodort.marvelheroes.presentation.presenter.impl.HeroesPresenterImpl;
import com.software.jgodort.marvelheroes.threading.Executor;
import com.software.jgodort.marvelheroes.threading.MainThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module to provides presenters.
 * Created by javier.godino on 08/08/2017.
 */
@Module
public class PresentersModule {

    @Provides
    @Singleton
    HeroesPresenter providesHeroesPresenter(Executor executor, MainThread mainThread) {
        return new HeroesPresenterImpl(executor, mainThread);
    }
}
