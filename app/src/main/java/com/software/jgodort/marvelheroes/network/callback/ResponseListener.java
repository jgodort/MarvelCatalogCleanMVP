package com.software.jgodort.marvelheroes.network.callback;

/**
 * This generic interface handle the response of the services through a listener.
 * Created by javie on 07/08/2017.
 */

public interface ResponseListener<T> {

    void onSuccess(T responese);

    void onFailure(T error);

}
