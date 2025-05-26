package com.interview.ipgeolocalizer.controller;

import com.interview.ipgeolocalizer.model.IpConsultResponse;
import com.interview.ipgeolocalizer.service.CityService;
import com.interview.ipgeolocalizer.utils.MinimumDistanceExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ip")
public class IpgeolocalizerController {
    @Autowired
    private CityService cityService;

    @PostMapping("/save/{ip}")
    public ResponseEntity<IpConsultResponse> receiveIp(@PathVariable("ip") String ip){

        try {
            return  ResponseEntity.ok(cityService.save(ip));
        } catch (Exception e) {
        e.printStackTrace();
                }
        return null;
    }

}
