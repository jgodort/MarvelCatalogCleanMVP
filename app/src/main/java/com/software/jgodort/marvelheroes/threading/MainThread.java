package com.software.jgodort.marvelheroes.threading;

/**
 * This interface will define a class that will enable interactors to run certain operations
 * on the main(UI) thread.
 * <p>
 * For example, if an interactor needs to show an object to the UI, this can be use to make
 * sure the show methods are called o the UI thread.
 * <p>
 * Created by javie on 07/08/2017.
 */

public interface MainThread {

    /**
     * Make runnable operations run in the main thread.
     *
     * @param runnable the runnable to run.
     */
    void post(final Runnable runnable);
}
