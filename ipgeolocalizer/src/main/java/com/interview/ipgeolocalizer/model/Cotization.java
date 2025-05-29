package com.interview.ipgeolocalizer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Cotization")
public class Cotization {

    @Id
    private String id;
    private double cotization;

    public Cotization(String id, double cotization) {
        this.id = id;
        this.cotization = cotization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCotization() {
        return cotization;
    }

    public void setCotization(double cotization) {
        this.cotization = cotization;
    }
}
