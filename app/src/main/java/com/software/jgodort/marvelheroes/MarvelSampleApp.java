package com.software.jgodort.marvelheroes;

import android.app.Application;

import com.software.jgodort.marvelheroes.dependencyInjection.ApplicationComponent;
import com.software.jgodort.marvelheroes.dependencyInjection.ApplicationModule;
import com.software.jgodort.marvelheroes.dependencyInjection.InteractorsModule;
import com.software.jgodort.marvelheroes.dependencyInjection.PresentersModule;
import com.software.jgodort.marvelheroes.dependencyInjection.RetrofitModule;

/**
 * Application class that allows us to configure libraries.
 * Created by javie on 07/08/2017.
 */

public class MarvelSampleApp extends Application {

    private static MarvelSampleApp app;

    /**
     * Dagger Component to manage the dependency injection.
     */
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;

        configureDaggerComponent();

    }

    /**
     * Method that initialize the DaggerComponent with the required modules.
     */
    private void configureDaggerComponent() {
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(app))
                .retrofitModule(new RetrofitModule())
                .interactorsModule(new InteractorsModule())
                .presentersModule(new PresentersModule())
                .build();
    }

    public static MarvelSampleApp getApp() {
        return app;
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
