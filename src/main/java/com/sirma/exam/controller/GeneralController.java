package com.sirma.exam.controller;

import com.sirma.exam.dto.InfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GeneralController {

    @GetMapping
    public InfoResponse gifInfo() {
        return InfoResponse.builder()
                .appName("Santa's Workshop API")
                .version("1.0.0")
                .serverTime(LocalDateTime.now())
                .resources(List.of("gift", "elves", "deliveries"))
                .build();
    }
}
