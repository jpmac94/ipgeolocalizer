package com.interview.ipgeolocalizer.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ip")
public class IpgeolocalizerController {

    @PostMapping("/save/{ip}")
    public ResponseEntity<String> receiveIp(@PathVariable("ip") String ip){
        System.out.println(ip);
        return  ResponseEntity.ok("success "+ip);
    }

    @GetMapping("/ip")
    public String getClientIp(HttpServletRequest request, @RequestHeader(value = "X-Forwarded-For", required = false) String xForwardedFor) {
        String ip;

        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            // Puede contener varias IPs, tomamos la primera
            ip = xForwardedFor.split(",")[0].trim();
        } else {
            ip = request.getRemoteAddr();
        }

        return "IP del cliente: " + ip;
    }
}
