
package com.software.jgodort.marvelheroes.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Superhero implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("realName")
    @Expose
    private String realName;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("abilities")
    @Expose
    private String abilities;
    @SerializedName("groups")
    @Expose
    private String groups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getAbilities() {
        return abilities;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.photo);
        dest.writeString(this.realName);
        dest.writeString(this.height);
        dest.writeString(this.power);
        dest.writeString(this.abilities);
        dest.writeString(this.groups);
    }

    public Superhero() {
    }

    protected Superhero(Parcel in) {
        this.name = in.readString();
        this.photo = in.readString();
        this.realName = in.readString();
        this.height = in.readString();
        this.power = in.readString();
        this.abilities = in.readString();
        this.groups = in.readString();
    }

    public static final Parcelable.Creator<Superhero> CREATOR = new Parcelable.Creator<Superhero>() {
        @Override
        public Superhero createFromParcel(Parcel source) {
            return new Superhero(source);
        }

        @Override
        public Superhero[] newArray(int size) {
            return new Superhero[size];
        }
    };
}
