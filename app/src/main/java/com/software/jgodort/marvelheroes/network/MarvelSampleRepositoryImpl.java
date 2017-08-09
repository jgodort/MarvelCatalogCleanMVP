package com.software.jgodort.marvelheroes.network;

import com.software.jgodort.marvelheroes.MarvelSampleApp;
import com.software.jgodort.marvelheroes.network.callback.ResponseCallback;
import com.software.jgodort.marvelheroes.network.callback.ResponseListener;
import com.software.jgodort.marvelheroes.network.model.SuperHeroes;

import javax.inject.Inject;

import retrofit2.Call;

/**
 *
 * Class that implements the interaction with the Rest API.
 * Created by javie on 07/08/2017.
 */
public class MarvelSampleRepositoryImpl implements MarvelSampleRepository {

    @Inject
    MarvelSampleAPI marvelSampleAPI;

    public MarvelSampleRepositoryImpl() {
        MarvelSampleApp.getApp().getApplicationComponent().inject(this);
    }

    @Override
    public void getSuperheroes(ResponseListener listener) {
        ResponseCallback<SuperHeroes> responseCallback = new ResponseCallback<>(listener);
        Call<SuperHeroes> call = marvelSampleAPI.getMarvelSuperHeroes();
        call.enqueue(responseCallback);
    }
}
