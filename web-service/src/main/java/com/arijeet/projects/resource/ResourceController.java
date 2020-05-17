package com.arijeet.projects.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    private static Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);

    @GetMapping("/ping")
    public String healthAPI(){
        LOGGER.info("Checking health");
        return "pong";
    }

}
