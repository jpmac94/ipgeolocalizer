package com.interview.ipgeolocalizer;

import com.interview.ipgeolocalizer.model.IpGeolocalized;
import com.interview.ipgeolocalizer.repository.IpGeolocalizationClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FeignTest {

    @Autowired
    private IpGeolocalizationClient ipGeolocalizationClient;

    @Test
    public void getLocalization(){
      IpGeolocalized ipGeolocalized= ipGeolocalizationClient.getLocalization("190.210.32.192");
        System.out.println(ipGeolocalized.getLat());
    }

    @Test
    public void getLocalizationFailed(){
        IpGeolocalized ipGeolocalized= ipGeolocalizationClient.getLocalization("1");
        System.out.println(ipGeolocalized.getLat()==null);
    }
}
