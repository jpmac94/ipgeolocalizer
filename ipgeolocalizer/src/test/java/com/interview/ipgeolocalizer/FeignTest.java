package com.interview.ipgeolocalizer;

import com.interview.ipgeolocalizer.model.GeoLocalizedIp;
import com.interview.ipgeolocalizer.repository.IpGeolocalizationClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FeignTest {

    @Autowired
    private IpGeolocalizationClient ipGeolocalizationClient;

    @Test
    public void getLocalization(){
        GeoLocalizedIp geoLocalizedIp=ipGeolocalizationClient.getLocalization("190.210.32.192");
        System.out.println(geoLocalizedIp.getCurrency().getCode());
        System.out.println(geoLocalizedIp.getLocation().getCountry().getCode());
        System.out.println(geoLocalizedIp.getLocation().getCountry().getName());
        System.out.println(geoLocalizedIp.getTime_zone().getCurrent_time());
        System.out.println(geoLocalizedIp.getLocation().getLanguage().getName());
        System.out.println(geoLocalizedIp.getLocation().getLanguage().getCode());
        System.out.println(geoLocalizedIp.getLocation().getLatitude());
        System.out.println(geoLocalizedIp.getLocation().getLongitude());
    }

    @Test
    public void getLocalizationFailed(){
       // IpGeolocalized ipGeolocalized= ipGeolocalizationClient.getLocalization("1");
        //System.out.println(ipGeolocalized.getLat()==null);
    }
}
