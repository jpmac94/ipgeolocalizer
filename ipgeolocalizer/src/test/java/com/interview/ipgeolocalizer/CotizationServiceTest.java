package com.interview.ipgeolocalizer;

import com.interview.ipgeolocalizer.model.Cotization;
import com.interview.ipgeolocalizer.service.CotizationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CotizationServiceTest {

    @Autowired
    private CotizationService cotizationService;

    @Test
    public void saveCotization(){
        Cotization cotization=new Cotization("ARS",1300.00);
        cotizationService.saveCotization(cotization);
    }

    @Test
    public void getCotization(){
        Assertions.assertThat(cotizationService.getCotizationById("ARS").getCotization()==1300.00);
    }
}
