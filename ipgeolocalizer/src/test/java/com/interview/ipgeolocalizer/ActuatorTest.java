package com.interview.ipgeolocalizer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ActuatorTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testEndpoint(){
        String url="http://localhost:"+port+"/actuator/health";

        ResponseEntity<String> responseEntity=testRestTemplate.getForEntity(url,String.class);
        Assertions.assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
    }
}
