package com.demo.consumer.resttemplate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class RestTemplateClient {
    private static final String url = "http://localhost:8081";

    private final RestTemplate restTemplate;

    public String getInstanceInfo() {
        return restTemplate.getForObject(url + "/instance-info", String.class);
    }
}
