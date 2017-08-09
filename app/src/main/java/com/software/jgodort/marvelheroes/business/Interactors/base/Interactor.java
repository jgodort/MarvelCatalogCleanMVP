package com.software.jgodort.marvelheroes.business.Interactors.base;

/**
 * This is the main interface of an interactor.
 * Each interactor serves a specific use case.
 *
 * Created by javie on 07/08/2017.
 */

public interface Interactor {

    /**
     * Thisis the main method to start an interactor.
     * It will make sure that the interactor operation
     * is done on an background thread.
     */
    void execute();
}
