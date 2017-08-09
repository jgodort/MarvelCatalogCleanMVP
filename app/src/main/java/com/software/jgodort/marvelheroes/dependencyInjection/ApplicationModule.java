package com.software.jgodort.marvelheroes.dependencyInjection;

import android.app.Application;
import android.content.Context;

import com.software.jgodort.marvelheroes.MarvelSampleApp;
import com.software.jgodort.marvelheroes.network.MarvelSampleRepository;
import com.software.jgodort.marvelheroes.network.MarvelSampleRepositoryImpl;
import com.software.jgodort.marvelheroes.threading.Executor;
import com.software.jgodort.marvelheroes.threading.MainThread;
import com.software.jgodort.marvelheroes.threading.impl.MainThreadImpl;
import com.software.jgodort.marvelheroes.threading.impl.ThreadExecutorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger Module to provides all related with android framework.
 * Created by javie on 07/08/2017.
 */

@Module
public class ApplicationModule {

    private MarvelSampleApp mMarvelSampleApp;

    public ApplicationModule(MarvelSampleApp app){
        mMarvelSampleApp=app;
    }

    @Provides
    @Singleton
    Application providesApplication(){
        return mMarvelSampleApp;
    }

    @Provides
    @Singleton
    Context providesContext(){
        return mMarvelSampleApp.getApplicationContext();
    }

    @Provides
    @Singleton
    Executor providesThreadExecutor(){
        return ThreadExecutorImpl.getInstance();
    }

    @Provides
    @Singleton
    MainThread providesMainThread(){
        return MainThreadImpl.getInstance();
    }

    @Provides
    @Singleton
    MarvelSampleRepository providesMarvelSampleRepository(){
        return new MarvelSampleRepositoryImpl();
    }

}
