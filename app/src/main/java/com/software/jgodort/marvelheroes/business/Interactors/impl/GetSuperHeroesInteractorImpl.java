package com.software.jgodort.marvelheroes.business.Interactors.impl;

import com.software.jgodort.marvelheroes.MarvelSampleApp;
import com.software.jgodort.marvelheroes.business.Interactors.GetSuperHeroesInteractor;
import com.software.jgodort.marvelheroes.business.Interactors.base.AbstractInteractor;
import com.software.jgodort.marvelheroes.network.MarvelSampleRepository;
import com.software.jgodort.marvelheroes.network.callback.ResponseListener;
import com.software.jgodort.marvelheroes.network.model.SuperHeroes;
import com.software.jgodort.marvelheroes.threading.Executor;
import com.software.jgodort.marvelheroes.threading.MainThread;

import javax.inject.Inject;

/**
 * Interactor to retrieve Superheroes from the Rest service.
 * <p>
 * Created by javie on 07/08/2017.
 */
public class GetSuperHeroesInteractorImpl extends AbstractInteractor implements GetSuperHeroesInteractor {

    /**
     * Instance of the callback to return data retrieved.
     */
    private GetSuperHeroesInteractor.SuperHeroesCallback mCallback;

    /**
     * Repository to use the API services.
     */
    @Inject
    MarvelSampleRepository marvelSampleRepository;

    public GetSuperHeroesInteractorImpl(Executor threadExecutor, MainThread mainThread) {
        super(threadExecutor, mainThread);
        MarvelSampleApp.getApp().getApplicationComponent().inject(this);
    }

    @Override
    public void run() {

        ResponseListener listener = new ResponseListener() {
            @Override
            public void onSuccess(Object responese) {
                postSuperHeroes((SuperHeroes) responese);
            }

            @Override
            public void onFailure(Object error) {
                if (error != null) {
                    notifyError(((Exception) error).getMessage());
                } else {
                    notifyError("Default Error");
                }
            }
        };

        marvelSampleRepository.getSuperheroes(listener);
    }

    /**
     * Method to sent the data to the layer which uses the callback.
     *
     * @param superHeroes
     */
    private void postSuperHeroes(final SuperHeroes superHeroes) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSuperHeroesRetrieved(superHeroes);
            }
        });
    }

    /**
     * Method to sent the proper error to the layer which uses the callback.
     *
     * @param error
     */
    private void notifyError(final String error) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSuperHeroesRetrievedError(error);
            }
        });
    }

    /**
     * Setter to configure the callback of the Interactor.
     *
     * @param callback
     */
    @Override
    public void setCallback(SuperHeroesCallback callback) {
        this.mCallback = callback;
    }
}
