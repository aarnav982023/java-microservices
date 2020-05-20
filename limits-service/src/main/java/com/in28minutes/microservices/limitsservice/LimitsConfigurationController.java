package com.in28minutes.microservices.limitsservice;

import com.in28minutes.microservices.limitsservice.bean.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    @Autowired
    Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsFromConfiguration(){
        return new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());
    }
}
