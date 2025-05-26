package com.interview.ipgeolocalizer.utils;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class AverageDistanceExporter {
    private AtomicLong distance=new AtomicLong(0);

    public AverageDistanceExporter(MeterRegistry registry) {
        registry.gauge("custom_average_distance",distance);
    }

    public AtomicLong getDistance(){
        return distance;
    }
    public void setDistance(long distance){
        this.distance.set(distance);
    }

}
