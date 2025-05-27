package com.interview.ipgeolocalizer.model;

public class GeoLocalizedIp {
    private Currency currency;
    private Location location;
    private Time_zone time_zone;

    public Time_zone getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(Time_zone time_zone) {
        this.time_zone = time_zone;
    }

    public GeoLocalizedIp(Currency currency, Location location, Time_zone time_zone) {
        this.currency = currency;
        this.location = location;
        this.time_zone = time_zone;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
