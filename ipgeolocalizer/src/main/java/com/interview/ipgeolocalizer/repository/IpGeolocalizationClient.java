package com.interview.ipgeolocalizer.repository;

import com.interview.ipgeolocalizer.model.IpGeolocalized;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ipgeolocalization",url = "http://ip-api.com/json/")
public interface IpGeolocalizationClient {

    @GetMapping("/{ip}")
    IpGeolocalized getLocalization(@PathVariable("ip") String ip);
}
