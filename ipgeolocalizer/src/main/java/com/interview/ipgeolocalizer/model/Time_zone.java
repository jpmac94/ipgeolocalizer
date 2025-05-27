package com.interview.ipgeolocalizer.model;

public class Time_zone {
    private String abbreviation;
    private String current_time;

    public Time_zone(String current_time,String abbreviation) {
        this.current_time = current_time;
        this.abbreviation=abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(String current_time) {
        this.current_time = current_time;
    }
}
