package com.demo.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class InstanceController {
    @Value("${server.port}")
    private String port;

    private final String instanceId = java.util.UUID.randomUUID().toString();

    @GetMapping("/instance-info")
    public String getInstanceInfo() {
        log.info("Request Received on instance running: {}", port);
        return "Instance served by Port: " + port + ". Instance id: " + instanceId;
    }
}
