package com.software.jgodort.marvelheroes.network.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class to manage the response of any call to API.
 * Created by javie on 07/08/2017.
 */

public class ResponseCallback<T> implements Callback<T> {

    private ResponseListener<T> listener;


    /**
     * Default constructor.
     *
     * @param listener to return the response.
     */
    public ResponseCallback(ResponseListener<T> listener) {
        this.listener = listener;
    }


    /**
     * Method to manage the response of the service.
     *
     * @param call     Object that represent the network call.
     * @param response Object that represent the response of the service.
     */
    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful()) {
            this.listener.onSuccess(response.body());
        } else {
            this.listener.onSuccess(null);
        }
    }

    /**
     * Method to manage the failures on the Api calls.
     *
     * @param call instance of <>{@link Call}</> with all the information about the error.
     * @param t    instance  of a throwable object.
     */
    @Override
    public void onFailure(Call<T> call, Throwable t) {

        this.listener.onFailure((T) t.getCause());
    }
}
