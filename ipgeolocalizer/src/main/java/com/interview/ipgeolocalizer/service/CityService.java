package com.interview.ipgeolocalizer.service;

import com.interview.ipgeolocalizer.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository redisRepository;

    @Autowired
    public CityService(CityRepository redisRepository) {
        this.redisRepository = redisRepository;
    }
}
