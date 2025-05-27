package com.interview.ipgeolocalizer.model;

public class IpConsultResponse {
    private String country;
    private String countryCode;
    private String timezone;
    private String currency;
    private String language;
    private String time;
    long distance;

    public IpConsultResponse(String country,
                             String countryCode,
                             String timezone,
                             String currency,
                             String language,
                             String time,
                             long distance) {
        this.country = country;
        this.countryCode = countryCode;
        this.timezone = timezone;
        this.currency = currency;
        this.language = language;
        this.time = time;
        this.distance = distance;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }
}
