package com.interview.ipgeolocalizer.model;

public class Location {
    private Country country;
    private String latitude;
    private String longitude;
    private Language language;

    public Location(Country country, String latitude, String longitude, Language language) {
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.language = language;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
