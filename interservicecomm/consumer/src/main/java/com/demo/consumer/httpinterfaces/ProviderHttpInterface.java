package com.demo.consumer.httpinterfaces;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ProviderHttpInterface {
    @GetExchange ("/instance-info")
    public String getInstance();
}
