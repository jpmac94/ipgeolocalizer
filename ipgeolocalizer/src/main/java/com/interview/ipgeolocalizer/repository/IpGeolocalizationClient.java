package com.interview.ipgeolocalizer.repository;

import com.interview.ipgeolocalizer.config.FeignConfiguration;
import com.interview.ipgeolocalizer.model.GeoLocalizedIp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ipgeolocalization",url = "https://api.ipregistry.co/",configuration = FeignConfiguration.class)
public interface IpGeolocalizationClient {
 // https://api.ipregistry.co/2800:40:74:f41:e21b:931e:f6a4:2be9?key=ira_bv8neM63BibiKXdf5C1RKZhxac3Uxm2w4hUe
    @GetMapping("/{ip}?key=ira_bv8neM63BibiKXdf5C1RKZhxac3Uxm2w4hUe")
    GeoLocalizedIp getLocalization(@PathVariable("ip") String ip);
}
