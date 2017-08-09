package com.software.jgodort.marvelheroes.dependencyInjection;


import com.software.jgodort.marvelheroes.business.Interactors.GetSuperHeroesInteractor;
import com.software.jgodort.marvelheroes.business.Interactors.impl.GetSuperHeroesInteractorImpl;
import com.software.jgodort.marvelheroes.threading.Executor;
import com.software.jgodort.marvelheroes.threading.MainThread;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module to provides interactor for the use cases
 * Created by javier.godino on 08/08/2017.
 */

@Module
public class InteractorsModule {

    @Provides
    GetSuperHeroesInteractor providesGetSuperHeroesInteractor(Executor executor, MainThread mainThread){
        return new GetSuperHeroesInteractorImpl(executor,mainThread);
    }
}
