package com.lionelnkeoua.pluralsight1.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Skill {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("score")
    @Expose
    private String skill;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;

    public Skill(String name, String skill, String country, String imageUrl) {
        this.name = name;
        this.skill = skill;
        this.country = country;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
