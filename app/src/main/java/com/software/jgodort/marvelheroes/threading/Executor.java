package com.software.jgodort.marvelheroes.threading;

import com.software.jgodort.marvelheroes.business.Interactors.base.AbstractInteractor;

/**
 * This executor is responsible for running interactors on background threads.
 * Created by javie on 07/08/2017.
 */

public interface Executor {


    /**
     * This method should call the interactor´s run method
     * and thus start the interactor.
     * This should be called on a background thread as interactors
     * might do lengthy operations.
     */
    void execute(final AbstractInteractor interactor);
}
