package com.software.jgodort.marvelheroes.business.Interactors.base;

import com.software.jgodort.marvelheroes.threading.Executor;
import com.software.jgodort.marvelheroes.threading.MainThread;

/**
 * This abstract class implements some common methods for all interactors.
 * Cancelling an interactor, check if it´s running and finish has mostly
 * the same code throughout so that is why this class was created.
 * Field methods are delivered volatile as we might use these methods from
 * different threads. (mainly from UI.)
 * Created by javie on 07/08/2017.
 */

public abstract class AbstractInteractor implements Interactor {

    protected Executor mThreadExecutor;

    protected MainThread mMainThread;

    protected volatile boolean mIsCancelled;
    protected volatile boolean mIsRunning;

    public AbstractInteractor(Executor threadExecutor, MainThread mainThread) {
        mThreadExecutor = threadExecutor;
        mMainThread = mainThread;
    }

    /**
     * This method contains the actual business logic of the interactor. It SHOULD NOT BE USED DIRECTLY but, instead,
     * a developer should call the execute() method of an interactor to make sure the operation is done on a background
     * thread.
     * <p/>
     * This method should only be called directly while doing unit/integration test. That is the only reason it is declared
     * public as to help with easier testing.
     */
    public abstract void run();

    public void onFinished() {
        mIsRunning = false;
        mIsCancelled = false;
    }

    public void cancel() {
        mIsCancelled = true;
        mIsRunning = false;
    }

    public void execute() {
        this.mIsRunning = true;
        mThreadExecutor.execute(this);

    }
}
