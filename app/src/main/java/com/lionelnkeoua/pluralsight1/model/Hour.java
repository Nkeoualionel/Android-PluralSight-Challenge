package com.lionelnkeoua.pluralsight1.model;

public class Hour {

    private String name;
    private String hour;
    private String country;
    private String imageUrl;

    public Hour(String name, String hour, String country, String imageUrl) {
        this.name = name;
        this.hour = hour;
        this.country = country;
        this.imageUrl = imageUrl;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
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
