package com.software.jgodort.marvelheroes.presentation.ui.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.software.jgodort.marvelheroes.MarvelSampleApp;
import com.software.jgodort.marvelheroes.R;
import com.software.jgodort.marvelheroes.network.model.Superhero;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter to display the list of heroes retrieved  by the API.
 * Created by javier.godino on 08/08/2017.
 */

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    /**
     * Context provided by Dagger.
     */
    @Inject
    Context context;

    /**
     * Listener to manage the OnClick event.
     */
    private OnClickHandler mOnClickHandler;
    /**
     * List of heroes.
     */
    private List<Superhero> mHeroes;

    public HeroesAdapter(OnClickHandler onClickHandler) {
        MarvelSampleApp.getApp().getApplicationComponent().inject(this);
        this.mOnClickHandler = onClickHandler;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_hero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Superhero hero = mHeroes.get(position);

        holder.cardViewHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnClickHandler.onHeroSelected(hero, holder);
            }
        });

        //Load round image using Glide.
        Glide.with(context).
                load(hero.getPhoto()).
                asBitmap().
                centerCrop().
                into(new BitmapImageViewTarget(holder.heroProfileImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        //Customize the drawable to make a round ImageView
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        holder.heroProfileImage.setImageDrawable(circularBitmapDrawable);
                    }
                });

        holder.superHeroName.setText(hero.getName());
        holder.realName.setText(hero.getRealName());
        holder.heroGroups.setText(hero.getGroups());


    }

    @Override
    public int getItemCount() {
        return mHeroes != null ? mHeroes.size() : 0;
    }


    public List<Superhero> getmHeroes() {
        return mHeroes;
    }

    public void setmHeroes(List<Superhero> mHeroes) {
        this.mHeroes = mHeroes;
    }

    /**
     * View holder to represent one item on the list.
     */
    public final class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_item)
        CardView cardViewHero;

        @BindView(R.id.hero_image)
        ImageView heroProfileImage;

        @BindView(R.id.superhero_name)
        TextView superHeroName;

        @BindView(R.id.real_name)
        TextView realName;

        @BindView(R.id.hero_groups)
        TextView heroGroups;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public CardView getCardViewHero() {
            return cardViewHero;
        }

        public ImageView getHeroProfileImage() {
            return heroProfileImage;
        }

        public TextView getSuperHeroName() {
            return superHeroName;
        }

        public TextView getRealName() {
            return realName;
        }

        public TextView getHeroGroups() {
            return heroGroups;
        }
    }

    /**
     * With this interface we can manage the selection on the list.
     */
    public interface OnClickHandler {
        void onHeroSelected(Superhero hero, HeroesAdapter.ViewHolder vh);
    }
}
