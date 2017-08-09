
package com.software.jgodort.marvelheroes.network.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class SuperHeroes {

    @SerializedName("superheroes")
    private List<Superhero> superheroes = null;

    public List<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(List<Superhero> superheroes) {
        this.superheroes = superheroes;
    }

}
