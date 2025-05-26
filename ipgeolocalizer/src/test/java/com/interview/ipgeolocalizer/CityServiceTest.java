package com.interview.ipgeolocalizer;

import com.interview.ipgeolocalizer.service.CityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    public void calcularDistancia(){
        System.out.println(cityService.calcularDistanciaABsAs( -34.6049,-0.1696));
    }
}
