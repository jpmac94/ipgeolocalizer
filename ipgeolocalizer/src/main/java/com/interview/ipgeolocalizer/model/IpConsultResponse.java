package com.interview.ipgeolocalizer.model;

public class IpConsultResponse {
    String country;
    String countryCode;
    String timezone;
    long distance;

    public IpConsultResponse(String country, String countryCode, String timezone, long distance) {
        this.country = country;
        this.countryCode = countryCode;
        this.timezone = timezone;
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

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }
}
