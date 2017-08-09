package com.software.jgodort.marvelheroes.threading.impl;

import android.os.Handler;
import android.os.Looper;

import com.software.jgodort.marvelheroes.threading.MainThread;

/**
 * Class that implement <>{@link MainThread}</> and allow us to execute runnables on the Maint Thread(UI).
 * Created by javie on 07/08/2017.
 */

public class MainThreadImpl implements MainThread {


    private static MainThread sMainThread;

    private Handler mHandler;

    private MainThreadImpl() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static MainThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new MainThreadImpl();
        }
        return sMainThread;
    }

    @Override
    public void post(Runnable runnable) {
        mHandler.post(runnable);
    }
}
