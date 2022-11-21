package com.haylion.charge.gateway.handler;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FallbackController {

    @RequestMapping("/defallback")
    public String fallback() {
        return "fallback";
    }
}

