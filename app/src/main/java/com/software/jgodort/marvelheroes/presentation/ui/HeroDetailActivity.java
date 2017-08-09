package com.software.jgodort.marvelheroes.presentation.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.software.jgodort.marvelheroes.R;
import com.software.jgodort.marvelheroes.network.model.Superhero;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Activity to display the details of the selected hero.
 * At is does not have business interaction or any specific logic, we don´t implement a Presenter.
 * <p>
 * Created by javie on 08/08/2017.
 */
public class HeroDetailActivity extends AppCompatActivity {


    @BindView(R.id.hero_powers)
    TextView mHeroPowers;

    @BindView(R.id.hero_info)
    TextView mHeroInfo;

    @BindView(R.id.hero_abilitites)
    TextView mHeroAbilities;

    @BindView(R.id.hero_groups)
    TextView mHeroGroups;

    @BindView(R.id.superhero_name)
    TextView mSuperheroName;

    @BindView(R.id.real_name)
    TextView mRealName;

    @BindView(R.id.hero_image_profile)
    ImageView mHeroProfileImage;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_details);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            init((Superhero) bundle.getParcelable(HeroesActivity.HERO_BUNDLE));
        }
    }

    /**
     * Method to initialize variables in the view.
     *
     * @param hero selected hero.
     */
    private void init(Superhero hero) {

        mHeroPowers.setText(hero.getPower());
        mHeroAbilities.setText(hero.getAbilities());
        mHeroGroups.setText(hero.getGroups());
        mHeroInfo.setText(hero.getHeight());
        mSuperheroName.setText(hero.getName());
        mRealName.setText(hero.getRealName());

        //Load round image using Glide.
        Glide.with(this).
                load(hero.getPhoto()).
                asBitmap().
                centerCrop().
                into(new BitmapImageViewTarget(mHeroProfileImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        //Customize the drawable to make a round ImageView
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(HeroDetailActivity.this.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        mHeroProfileImage.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }
}
