package com.interview.ipgeolocalizer.controller;

import com.interview.ipgeolocalizer.model.IpConsultResponse;
import com.interview.ipgeolocalizer.service.CityService;
import com.interview.ipgeolocalizer.utils.MinimumDistanceExporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ip")
public class IpgeolocalizerController {
    private static final Logger logger = LoggerFactory.getLogger(IpgeolocalizerController.class);

    @Autowired
    private CityService cityService;

    @PostMapping("/consult/{ip}")
    public ResponseEntity<IpConsultResponse> receiveIp(@PathVariable("ip") String ip){
        logger.info("received ip in endpoint /ip/consult/{ip}: "+ip);
        return  ResponseEntity.ok(cityService.consult(ip));

    }


}
