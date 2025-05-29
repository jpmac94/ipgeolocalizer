package com.interview.ipgeolocalizer.repository;

import com.interview.ipgeolocalizer.config.FeignConfiguration;
import com.interview.ipgeolocalizer.model.ContizationsFixer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "cotization",url = "https://data.fixer.io/api",configuration = FeignConfiguration.class)
public interface CotizationClient {
    @GetMapping("/latest?access_key=a78b1579cbfee20e7e3c221c69aeee8f")
    ContizationsFixer getCotizations();
}
