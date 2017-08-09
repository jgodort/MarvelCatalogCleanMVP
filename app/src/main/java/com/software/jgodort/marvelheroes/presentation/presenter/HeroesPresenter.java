package com.software.jgodort.marvelheroes.presentation.presenter;

import com.software.jgodort.marvelheroes.network.model.SuperHeroes;
import com.software.jgodort.marvelheroes.presentation.presenter.base.BasePresenter;
import com.software.jgodort.marvelheroes.presentation.ui.BaseView;

/**
 * Interface to abstract the interaction of the view with the presenter.
 * Created by javie on 07/08/2017.
 */
public interface HeroesPresenter extends BasePresenter {

    /**
     * Interface to provide methods to Activities and fragment with
     * the aim of comunicate the presenter with the view.
     */
    interface View extends BaseView {

        void setHeroesRetrieved(SuperHeroes heroes);
    }

    /**
     * Method to vinculate the view with the presenter.
     *
     * @param view
     */
    void setView(View view);

    /**
     * Method to retrieve superheros from the API.
     */
    void getHeroes();
}

