package com.interview.ipgeolocalizer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@SpringBootTest
public class CotizationClient {
    @Autowired
    private com.interview.ipgeolocalizer.repository.CotizationClient cotizationClient;

    @Test
    public void getAllTest(){
        Map<String, Double> cotizations=cotizationClient.getCotizations().getRates();
        System.out.println(cotizations.get("ARS")+" - ARS");
    }


    @Test
    public void iterCotizations(){
        cotizationClient.getCotizations().getRates().forEach(
                (s,d)-> System.out.println(s+" - "+d.toString())
        );
    }

    @Test
    public void getDate(){
        String date=cotizationClient.getCotizations().getDate();
        Assertions.assertThat(LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE).isEqual(
                LocalDate.now().plusDays(1)));
    }
}
