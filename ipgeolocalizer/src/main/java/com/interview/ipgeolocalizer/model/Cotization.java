package com.interview.ipgeolocalizer.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Cotization")
public class Cotization {

    private String id;
    private String cotization;

    public Cotization(String id, String cotization) {
        this.id = id;
        this.cotization = cotization;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCotization() {
        return cotization;
    }

    public void setCotization(String cotization) {
        this.cotization = cotization;
    }
}
