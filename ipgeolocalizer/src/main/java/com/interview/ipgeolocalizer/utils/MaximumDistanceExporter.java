package com.interview.ipgeolocalizer.utils;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class MaximumDistanceExporter {
    private AtomicLong distance=new AtomicLong(0);

    public MaximumDistanceExporter(MeterRegistry registry) {
        registry.gauge("custom_maximum_distance",distance);
    }

    public AtomicLong getDistance(){
        return distance;
    }
    public void setDistance(long distance){
        this.distance.set(distance);
    }

}
