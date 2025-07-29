package com.deliverytech.delivery.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Map;
import java.time.LocalDateTime;


@RestController
public class HealthController {

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
            "status", "UP",
            "timestamp", LocalDateTime.now().toString(),
            "service", "Delivery API",
            "javaversion", System.getProperty("java.version")
        );
    }

    @GetMapping("/info")
    public AppInfo info() {
        return new AppInfo(
            "Delivery Tech API",
            "1.0.0",
            "Heitor Delvecchi",
            "JDK 21",
            "Spring Boot 3.5.x"
        );
    }

    public record AppInfo(
        String application,
        String version,
        String developer,
        String javaVersion,
        String framework 
    ) {}

}
