package com.software.jgodort.marvelheroes.presentation.ui;

/**
 * Interface to manage the basic operation on View.
 * Created by javie on 07/08/2017.
 */
public interface BaseView {

    /**
     * This is a general method used for showing some kind of progress during the background tasks.
     */
    void showProgress();

    /**
     * This is a general method used for hiding progress information after background tasks.
     */
    void hideProgress();


    /**
     * This method is used for showing error messages on the UI.
     *
     * @param message The message to display.
     */
    void showError(String message);

    /**
     * This method is use for showing messages on the UI.
     *
     * @param message The message to display.
     */
    void showMessage(String message);
}
