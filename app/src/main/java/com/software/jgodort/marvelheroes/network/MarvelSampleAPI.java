package com.software.jgodort.marvelheroes.network;

import com.software.jgodort.marvelheroes.network.model.SuperHeroes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by javie on 07/08/2017.
 */

public interface MarvelSampleAPI {


    /**
     * Get a list of <>{@link com.software.jgodort.marvelheroes.network.model.Superhero}</> from the rest service.
     *
     * @return a list of superheroes.
     */
    @GET("bins/bvyob")
    Call<SuperHeroes> getMarvelSuperHeroes();
}
