package com.software.jgodort.marvelheroes.presentation.presenter.base;

import com.software.jgodort.marvelheroes.threading.Executor;
import com.software.jgodort.marvelheroes.threading.MainThread;

/**
 * Created by javie on 07/08/2017.
 */

public  abstract class AbstractPresenter {

    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter( Executor executor, MainThread mainThread){
        mExecutor=executor;
        mMainThread=mainThread;

    }
}
