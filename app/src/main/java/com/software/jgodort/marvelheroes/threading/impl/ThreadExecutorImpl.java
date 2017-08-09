package com.software.jgodort.marvelheroes.threading.impl;

import com.software.jgodort.marvelheroes.business.Interactors.base.AbstractInteractor;
import com.software.jgodort.marvelheroes.threading.Executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Class that implements <>{@link Executor}</> and make sure that each interactor executes long running operations in background.
 * Created by javie on 07/08/2017.
 */

public class ThreadExecutorImpl implements Executor {


    // Keep a volatile instance of the ThreadExecutor
    // to keep the state through all threads.
    private static volatile ThreadExecutorImpl sThreadExecutor;

    //Inital pool size.
    private static final int CORE_POOL_SIZE = 3;
    //Max dimension size.
    private static final int MAX_POOL_SIZE = 5;
    //Max timeout.
    private static final int KEEP_ALIVE_TIME = 120;

    private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
    //Working queue which blocks new runnables until the current running is finished.
    private static final BlockingQueue<Runnable> WORK_QUEUE = new LinkedBlockingQueue<>();


    private ThreadPoolExecutor mThreadPoolExecutor;

    private ThreadExecutorImpl() {

        mThreadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                (long) KEEP_ALIVE_TIME,
                TIME_UNIT,
                WORK_QUEUE);

    }

    public static Executor getInstance() {
        if (sThreadExecutor == null) {
            sThreadExecutor = new ThreadExecutorImpl();
        }

        return sThreadExecutor;
    }

    @Override
    public void execute(final AbstractInteractor interactor) {

        mThreadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                interactor.run();

                interactor.onFinished();
            }
        });
    }
}
