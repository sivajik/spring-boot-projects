package com.demo.consumer.httpinterfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/httpinterfaces")
@RequiredArgsConstructor
public class HttpInterfacesController {
    private final ProviderHttpInterface providerHttpInterface;

    @GetMapping("/instance")
    public String getInstanceInfo() {
        return providerHttpInterface.getInstance();
    }
}
