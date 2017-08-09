package com.software.jgodort.marvelheroes.dependencyInjection;

import com.software.jgodort.marvelheroes.business.Interactors.impl.GetSuperHeroesInteractorImpl;
import com.software.jgodort.marvelheroes.network.MarvelSampleRepositoryImpl;
import com.software.jgodort.marvelheroes.presentation.presenter.impl.HeroesPresenterImpl;
import com.software.jgodort.marvelheroes.presentation.ui.HeroesActivity;
import com.software.jgodort.marvelheroes.presentation.ui.adapters.HeroesAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Component to define the dependency injection to layers.
 * Created by javie on 07/08/2017.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        RetrofitModule.class,
        InteractorsModule.class,
        PresentersModule.class
})
public interface ApplicationComponent {

    void inject(HeroesAdapter adapter);

    void inject(HeroesActivity heroesActivity);

    void inject(HeroesPresenterImpl heroesPresenter);

    void inject(MarvelSampleRepositoryImpl marvelSampleRepository);

    void inject(GetSuperHeroesInteractorImpl getSuperHeroesInteractor);
}
