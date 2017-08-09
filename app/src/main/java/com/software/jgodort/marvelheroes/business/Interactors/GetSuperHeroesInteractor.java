package com.software.jgodort.marvelheroes.business.Interactors;

import com.software.jgodort.marvelheroes.business.Interactors.base.Interactor;
import com.software.jgodort.marvelheroes.network.model.SuperHeroes;

/**
 * Created by javie on 07/08/2017.
 */

public interface GetSuperHeroesInteractor extends Interactor{

    interface  SuperHeroesCallback{
        void onSuperHeroesRetrieved(SuperHeroes superHeroes);
        void onSuperHeroesRetrievedError(String error);
    }

    void setCallback(SuperHeroesCallback callback);
}
