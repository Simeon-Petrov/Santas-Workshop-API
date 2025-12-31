package com.sirma.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfoResponse {
    private String appName;
    private String version;
    private LocalDateTime serverTime;
    private List<String> resources;
}
