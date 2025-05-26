package com.interview.ipgeolocalizer.utils;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class MinimumDistanceExporter {

    private AtomicLong distance=new AtomicLong(0);

    public MinimumDistanceExporter(MeterRegistry registry) {
        registry.gauge("custom_minimum_distance",distance);
    }

    public AtomicLong getDistance(){
        return distance;
    }

    public void setDistance(long distance){
        this.distance.set(distance);
    }
}
