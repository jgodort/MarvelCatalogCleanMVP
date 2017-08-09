package com.software.jgodort.marvelheroes.presentation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.software.jgodort.marvelheroes.MarvelSampleApp;
import com.software.jgodort.marvelheroes.R;
import com.software.jgodort.marvelheroes.network.model.SuperHeroes;
import com.software.jgodort.marvelheroes.network.model.Superhero;
import com.software.jgodort.marvelheroes.presentation.presenter.HeroesPresenter;
import com.software.jgodort.marvelheroes.presentation.ui.adapters.HeroesAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HeroesActivity extends AppCompatActivity
        implements HeroesPresenter.View,
        HeroesAdapter.OnClickHandler {

    private static final String TAG = HeroesActivity.class.getSimpleName();
    public static final String HERO_BUNDLE = "HEROBUNDLE_KEY";
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.recyclerSuperHeroes)
    RecyclerView mSuperHeroesRecycler;

    @BindView(R.id.loadingView)
    FrameLayout mLoadingView;

    @BindView(R.id.errorView)
    RelativeLayout mErrorView;

    @BindView(R.id.loadingAnimation)
    LottieAnimationView loadingAnimation;

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;


    @Inject
    HeroesPresenter heroesPresenter;

    private HeroesAdapter mHeroesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        ButterKnife.bind(this);
        MarvelSampleApp.getApp().getApplicationComponent().inject(this);
        init();
        heroesPresenter.getHeroes();
    }


    private void init() {
        toolbar.setTitle(getString(R.string.toolbarTitle));
        //Configure presenter
        heroesPresenter.setView(this);

        //Configure RecyclerView
        mSuperHeroesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //Configure Adapter
        mHeroesAdapter = new HeroesAdapter(this);
        mSuperHeroesRecycler.setAdapter(mHeroesAdapter);

        //Configure swipe refres layout.
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                heroesPresenter.getHeroes();
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        heroesPresenter.resume();
    }

    @Override
    public void onHeroSelected(Superhero hero, HeroesAdapter.ViewHolder vh) {

        Intent intent = new Intent(this, HeroDetailActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable(HERO_BUNDLE, hero);
        intent.putExtras(extras);
        Pair<View, String> p1 = Pair.create((View) vh.getHeroProfileImage(), getString(R.string.image_animation_name));
        Pair<View, String> p2 = Pair.create((View) vh.getSuperHeroName(), getString(R.string.superhero_animation_name));
        Pair<View, String> p3 = Pair.create((View) vh.getSuperHeroName(), getString(R.string.realname_animation_name));
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, p1, p2, p3);
        startActivity(intent, options.toBundle());
    }

    @Override
    public void showProgress() {
        mErrorView.setVisibility(View.GONE);
        mSuperHeroesRecycler.setVisibility(View.GONE);
        mLoadingView.setVisibility(View.VISIBLE);
        loadingAnimation.playAnimation();
    }

    @Override
    public void hideProgress() {
        mLoadingView.setVisibility(View.GONE);
        loadingAnimation.playAnimation();
    }

    @Override
    public void showError(String message) {
        mSwipeRefreshLayout.setRefreshing(false);
        Log.e(TAG, "showError: " + message);
        mErrorView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void setHeroesRetrieved(SuperHeroes heroes) {

        if (heroes != null &&
                heroes.getSuperheroes() != null &&
                !heroes.getSuperheroes().isEmpty()) {
            mSuperHeroesRecycler.setVisibility(View.VISIBLE);
            mHeroesAdapter.setmHeroes(heroes.getSuperheroes());
            mHeroesAdapter.notifyDataSetChanged();
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

}
