package com.software.jgodort.marvelheroes.network;

import com.software.jgodort.marvelheroes.network.callback.ResponseListener;

/**
 * Interface for MarvelSample Repository
 * Created by javie on 07/08/2017.
 */
public interface MarvelSampleRepository {

    void getSuperheroes(ResponseListener listener);
}
