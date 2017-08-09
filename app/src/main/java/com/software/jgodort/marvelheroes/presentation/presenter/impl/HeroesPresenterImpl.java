package com.software.jgodort.marvelheroes.presentation.presenter.impl;

import com.software.jgodort.marvelheroes.MarvelSampleApp;
import com.software.jgodort.marvelheroes.business.Interactors.GetSuperHeroesInteractor;
import com.software.jgodort.marvelheroes.network.model.SuperHeroes;
import com.software.jgodort.marvelheroes.presentation.presenter.HeroesPresenter;
import com.software.jgodort.marvelheroes.presentation.presenter.base.AbstractPresenter;
import com.software.jgodort.marvelheroes.threading.Executor;
import com.software.jgodort.marvelheroes.threading.MainThread;

import javax.inject.Inject;

/**
 * Created by javie on 07/08/2017.
 */
public class HeroesPresenterImpl extends AbstractPresenter
        implements HeroesPresenter,
        GetSuperHeroesInteractor.SuperHeroesCallback {

    /**
     * Related view.
     */
    private HeroesPresenter.View mView;

    /**
     * Interactor provided by Dagger.
     */
    @Inject
    GetSuperHeroesInteractor superHeroesInteractor;


    public HeroesPresenterImpl(Executor executor, MainThread mainThread) {
        super(executor, mainThread);
        MarvelSampleApp.getApp().getApplicationComponent().inject(this);
        superHeroesInteractor.setCallback(this);
    }

    @Override
    public void setView(View view) {
        this.mView = view;
    }

    @Override
    public void getHeroes() {
        mView.showProgress();
        superHeroesInteractor.execute();
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void onError(String message) {
        mView.showError(message);
    }

    @Override
    public void onSuperHeroesRetrieved(SuperHeroes superHeroes) {
        mView.hideProgress();
        mView.setHeroesRetrieved(superHeroes);
    }

    @Override
    public void onSuperHeroesRetrievedError(String error) {
        mView.hideProgress();
        mView.showError(error);
    }
}
